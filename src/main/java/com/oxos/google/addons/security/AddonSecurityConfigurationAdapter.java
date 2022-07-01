package com.oxos.google.addons.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Slf4j
@Configuration
public class AddonSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter
{
	/*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	@Override
	protected void configure( HttpSecurity http ) throws Exception
	{
		http
				.authorizeRequests()
				.anyRequest().permitAll();
		http.csrf().disable();
		http.addFilterBefore( new AddonRequestAuthFilter(), BasicAuthenticationFilter.class );
		http.addFilterAfter( new AddonRequestParameterFilter(), AddonRequestAuthFilter.class );
	}
}

