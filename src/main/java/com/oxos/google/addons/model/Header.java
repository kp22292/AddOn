package com.oxos.google.addons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeName("header")
public class Header
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/
    private String title;
    private String subtitle;
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

