package com.oxos.google.addons.model.widget;

import com.fasterxml.jackson.annotation.*;
import com.oxos.google.addons.model.action.OnClick;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeName("image")
public class Image extends BaseWidget
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/
    
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private OnClick onClick;

	@JsonProperty( "imageUrl" )
	private String imageURL;

	@JsonProperty( "altText" )
	private String altText;

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

