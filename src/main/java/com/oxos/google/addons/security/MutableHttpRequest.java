package com.oxos.google.addons.security;

import com.google.common.io.ByteStreams;
import lombok.extern.slf4j.Slf4j;
import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.util.*;

@Slf4j
public class MutableHttpRequest extends HttpServletRequestWrapper
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private final Map<String, String[]> mutableParams = new HashMap<>();

	private ByteArrayOutputStream cachedBytes;
	
    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

	public MutableHttpRequest( final HttpServletRequest request )
	{
		super( request );
	}
	
    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	public MutableHttpRequest addParameter( String name, String value )
	{
		if (value != null) mutableParams.put( name, new String[] { value } );
		return this;
	}

	@Override
	public String getParameter( final String name )
	{
		String[] values = getParameterMap().get( name );

		return Arrays.stream( values )
				.findFirst()
				.orElse( super.getParameter( name ) );
	}

	@Override
	public Map<String, String[]> getParameterMap()
	{
		Map<String, String[]> allParameters = new HashMap<>();
		allParameters.putAll( super.getParameterMap() );
		allParameters.putAll( mutableParams );

		return Collections.unmodifiableMap( allParameters );
	}

	@Override
	public Enumeration<String> getParameterNames()
	{
		return Collections.enumeration( getParameterMap().keySet() );
	}

	@Override
	public String[] getParameterValues( final String name )
	{
		return getParameterMap().get( name );
	}

	@Override
	public ServletInputStream getInputStream() throws IOException
	{
		if (cachedBytes == null) cacheInputStream();
		return new CachedServletInputStream( cachedBytes.toByteArray() );
	}

	@Override
	public BufferedReader getReader() throws IOException
	{
		return new BufferedReader( new InputStreamReader( getInputStream() ) );
	}

    /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

	private void cacheInputStream() throws IOException
	{
		cachedBytes = new ByteArrayOutputStream();
		ByteStreams.copy( super.getInputStream(), cachedBytes );
	}

    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/
	
	/*--------------------------------------------
	|       I N L I N E    C L A S S E S        |
	============================================*/

	/* An input stream which reads the cached request body */
	private static class CachedServletInputStream extends ServletInputStream
	{
		private final ByteArrayInputStream buffer;

		public CachedServletInputStream( byte[] contents )
		{
			this.buffer = new ByteArrayInputStream( contents );
		}

		@Override
		public int read()
		{
			return buffer.read();
		}

		@Override
		public boolean isFinished()
		{
			return buffer.available() == 0;
		}

		@Override
		public boolean isReady()
		{
			return true;
		}

		@Override
		public void setReadListener( ReadListener listener )
		{
			throw new RuntimeException( "Not implemented" );
		}
	}
}

