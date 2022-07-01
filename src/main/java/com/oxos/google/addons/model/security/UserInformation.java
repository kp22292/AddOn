package com.oxos.google.addons.model.security;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Slf4j
@Data
@NoArgsConstructor
@RequestScope
@Component
public class UserInformation
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String email;
	private boolean emailVerified;
	private String name;

	private String locale;
	private String familyName;
	private String givenName;
}

