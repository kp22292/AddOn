package com.oxos.google.addons.security;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.oxos.google.addons.model.security.UserInformation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;

@Slf4j
@Component
public class AddonUserScopeInterceptor implements HandlerInterceptor
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

	private static final ObjectMapper mapper = new ObjectMapper();

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	@Autowired
	private UserInformation userInformation;

	/*--------------------------------------------
	|   P U B L I C    A P I    M E T H O D S   |
	============================================*/

	@Override
	public boolean preHandle( HttpServletRequest httpServletRequest, HttpServletResponse response, Object handler ) throws Exception
	{
		MutableHttpRequest mutableRequest = new MutableHttpRequest( httpServletRequest );
		JsonNode json = mapper.readTree( mutableRequest.getReader() );
		try
		{
			String idTokenString = json.at( "/authorizationEventObject/userIdToken" ).asText();
			GoogleIdTokenVerifier.Builder builder = new GoogleIdTokenVerifier.Builder(
					GoogleNetHttpTransport.newTrustedTransport(),
					GsonFactory.getDefaultInstance() );
			builder.setAudience( Collections.singletonList( AddonRequestAuthFilter.CLIENT_ID ) );
			GoogleIdTokenVerifier verifier = builder.build();
			GoogleIdToken decodedToken = verifier.verify( idTokenString );
			GoogleIdToken.Payload payload = decodedToken.getPayload();

			userInformation.setEmail( payload.getEmail() );
			userInformation.setEmailVerified( payload.getEmailVerified() );
			userInformation.setName( (String) payload.get( "name" ) );
			userInformation.setLocale( (String) payload.get( "locale" ) );
			userInformation.setFamilyName( (String) payload.get( "family_name" ) );
			userInformation.setGivenName( (String) payload.get( "given_name" ) );
		}
		catch ( Exception e )
		{
			log.trace( "Could not get google user information." );
		}

		return true;
	}
}

