package com.oxos.google.addons.model.navigation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class LandingAction
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	@JsonProperty( "action" )
	private Action action;
	
    /*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/
	
    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/	
	
    /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/	
	
    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/
	
	/*--------------------------------------------
	|       I N L I N E    C L A S S E S        |
	============================================*/
}

