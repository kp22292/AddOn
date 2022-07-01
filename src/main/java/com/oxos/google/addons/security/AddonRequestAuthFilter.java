package com.oxos.google.addons.security;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.json.gson.GsonFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//todo Figure out why this token is returning NULL when verifying
public class AddonRequestAuthFilter extends GenericFilterBean
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

	public static final String CLIENT_ID = "999852114099-9k54seitpmhdm2ic23qq6mmunuitl2nl.apps.googleusercontent.com";
	private static final String SERVICE_ACCOUNT_EMAIL = "service-999852114099@gcp-sa-gsuiteaddons.iam.gserviceaccount.com";
	
    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	@Override
	public void doFilter( ServletRequest request, ServletResponse response, FilterChain chain ) throws IOException, ServletException
	{
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String authHeader = httpRequest.getHeader( "Authorization" );

		if (authHeader == null || !authHeader.startsWith( "Bearer " ))
		{
			httpResponse.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Missing authorization header" );
			return;
		}
		String idTokenString = authHeader.substring( 7 );
		try
		{
			/*
			String currentUrl = httpRequest.getRequestURL().toString();
			GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
					GoogleNetHttpTransport.newTrustedTransport(),
					GsonFactory.getDefaultInstance() )
					.setIssuer( "https://accounts.google.com" )
					.setAudience( Collections.singletonList( currentUrl ) )
					.build();
			GoogleIdToken decodedToken = verifier.verify( idTokenString );
			if (decodedToken == null) throw new IllegalStateException( "Decoded token is null" );
			 */

			GoogleIdToken decodedToken = GoogleIdToken.parse( GsonFactory.getDefaultInstance(), idTokenString );
			GoogleIdToken.Payload payload = decodedToken.getPayload();
			if (SERVICE_ACCOUNT_EMAIL != null && !SERVICE_ACCOUNT_EMAIL.equals( payload.getEmail() ))
			{
				httpResponse.sendError( HttpServletResponse.SC_UNAUTHORIZED, "Invalid email in system idToken" );
				return;
			}
		}
		catch ( Exception e )
		{
			throw new IllegalArgumentException( "Security Issue with Request", e );
		}
		chain.doFilter( request, response );
	}
}

