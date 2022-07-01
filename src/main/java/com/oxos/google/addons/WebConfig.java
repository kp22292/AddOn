package com.oxos.google.addons;

import com.oxos.google.addons.security.AddonUserScopeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Component
public class WebConfig implements WebMvcConfigurer
{
    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	@Autowired
	private AddonUserScopeInterceptor userScopeInterceptor;

	@Override
	public void addInterceptors( InterceptorRegistry registry )
	{
		registry.addInterceptor( userScopeInterceptor ).addPathPatterns( "/**" );
	}
}

