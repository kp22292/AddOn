package com.oxos.google.addons.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.gson.stream.MalformedJsonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class AddonRequestParameterFilter extends GenericFilterBean
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

	private static final ObjectMapper mapper = new ObjectMapper();

    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	@Override
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
	{
		if (request instanceof HttpServletRequest)
		{
			HttpServletRequest httpServletRequest = (HttpServletRequest) request;
			String contentType = httpServletRequest.getContentType();
			if (contentType != null && contentType.contains( MediaType.APPLICATION_JSON_VALUE ) &&
					HttpMethod.POST.matches( httpServletRequest.getMethod() )) ;
			{
				MutableHttpRequest mutableRequest = new MutableHttpRequest( httpServletRequest );
				JsonNode json = mapper.readTree( mutableRequest.getReader() );
				try
				{
					if (json instanceof MissingNode) throw new MalformedJsonException( "Not a JSON block" );

					JsonNode formInputs = json.at( "/commonEventObject/formInputs" );
					Iterator<Map.Entry<String, JsonNode>> fieldList = formInputs.fields();
					while ( fieldList.hasNext() )
					{
						Map.Entry<String, JsonNode> field = fieldList.next();
						String parameterName = field.getKey();
						JsonNode paramterValue = field.getValue().findPath( "value" );
						if (( paramterValue != null ) && ( paramterValue.isArray() ))
						{
							for ( JsonNode item : paramterValue )
							{
								String itemValue = item.textValue();
								mutableRequest.addParameter( parameterName, itemValue );
							}
						}
						else if (field.getValue().findPath( "msSinceEpoch" ) != null)
						{
							JsonNode dateValue = field.getValue().findPath( "msSinceEpoch" );
							Double dateDouble = dateValue.doubleValue();
							OffsetDateTime ldt = OffsetDateTime.ofInstant(
									Instant.ofEpochMilli( dateDouble.longValue() ), ZoneOffset.systemDefault() );

							String dateText = ldt.format( DateTimeFormatter.ISO_DATE_TIME );
							mutableRequest.addParameter( parameterName, dateText );
						}
					}
				}
				catch ( MalformedJsonException jsonException )
				{
					log.trace( "Not a JSON Block. Continue" );
				}
				catch ( Exception e )
				{
					log.warn( "Could not parse JSON response", e );
				}

				chain.doFilter( mutableRequest, response );
				return;
			}
		}
		chain.doFilter( request, response );
	}
}

