package com.oxos.google.addons.screens;

import com.oxos.google.addons.model.*;
import com.oxos.google.addons.model.action.OnClick;
import com.oxos.google.addons.model.navigation.*;
import com.oxos.google.addons.model.security.UserInformation;
import com.oxos.google.addons.model.widget.*;
import com.oxos.google.addons.model.widget.input.DateTimePicker;
import com.oxos.google.addons.model.widget.input.TextInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class LandingResource
{
    /*--------------------------------------------
    |             C O N S T A N T S             |
    ============================================*/

	private static final String SERVER_ROOT = "3892-38-101-235-211.ngrok.io";

    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	@Autowired
	private UserInformation userInformation;

	/*--------------------------------------------
    |         C O N S T R U C T O R S           |
    ============================================*/

    /*--------------------------------------------
    |   P U B L I C    A P I    M E T H O D S   |
    ============================================*/

	@RequestMapping( value = "/landing", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json" )
	public LandingAction landingPage()
	{
		return LandingAction.builder()
				.action( Action.builder().navigation(
								Navigation.builder().pushCard(
										Card.builder().header( Header.builder().title( userInformation.getName() ).build() )
												.section(
														Section.builder().widget(
																TextParagraph.builder().text( "Your random cat 2:" ).build()
														).widget(
																Image.builder().imageURL( "https://cataas.com/cat" ).build()
														).widget(
																ButtonList.builder()
																		.button( Button.builder()
																				.text( "Happy" )
																				.color( Color.builder().red( 0 ).green( (float) 0.4784 ).blue( (float) 0.353 ).alpha( 1 ).build() )
																				.onClick( OnClick.builder()
																						.action( Action.builder()
																								.function( "https://" + SERVER_ROOT + "/landing/happy" )
																								.parameter( Action.ActionParameters.builder().key( "action" ).value( "happy" ).build() )
																								.build() )
																						.build() )
																				.build()
																		)

																		.button( Button.builder()
																				.text( "Sad" )
																				.color( Color.builder().red( 1 ).green( (float) 0.07843 ).blue( (float) 0.07843 ).alpha( 1 ).build() )
																				.onClick( OnClick.builder()
																						.action( Action.builder()
																								.function( "https://" + SERVER_ROOT + "/landing/sad" )
																								.parameter( Action.ActionParameters.builder().key( "action" ).value( "sad" ).build() )
																								.build() )
																						.build() )
																				.build()
																		).build()
														).widget(
																ButtonList.builder()
																		.button( Button.builder()
																				.text( "NDA Form" )
																				.color( Color.builder().red( (float) 0.38 ).green( (float) 0.765 ).blue( (float) 0.762 ).alpha( 1 ).build() )
																				.onClick( OnClick.builder()
																						.action( Action.builder()
																								.function( "https://" + SERVER_ROOT + "/landing/nda" )
																								.parameter( Action.ActionParameters.builder().key( "action" ).value( "nda" ).build() )
																								.build() )
																						.build() )
																				.build()
																		).build()
														).build()
												).build() ).build() )
						.build() )
				.build();
	}

	@RequestMapping( value = "/landing/happy", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json" )
	public RenderAction happy()
	{
		String imgUrl = "https://dg.imgix.net/do-you-think-you-re-happy-jgdbfiey-en/landscape/do-you-think-you-re-happy-jgdbfiey-9bb0198eeccd0a3c3c13aed064e2e2b3.jpg";
		return RenderAction.builder()
				.action( Action.builder().navigation(
								Navigation.builder().pushCard(
										Card.builder().section(
												Section.builder().widget(
																Image.builder().altText( "Happy" ).imageURL( imgUrl ).build() )
														.build()
										).build() ).build() )
						.build() )
				.build();
	}

	@RequestMapping( value = "/landing/sad", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json" )
	public RenderAction sad()
	{
		String imgUrl = "https://cdn.pixabay.com/photo/2017/08/15/12/58/emoticon-2643814_960_720.jpg";
		return RenderAction.builder()
				.action( Action.builder().navigation(
								Navigation.builder().pushCard(
										Card.builder().section(
												Section.builder().widget(
																Image.builder().altText( "Sad" ).imageURL( imgUrl ).build() )
														.build()
										).build() ).build() )
						.build() )
				.build();
	}

	@RequestMapping( value = "/landing/nda", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json" )
	public RenderAction nda()
	{
		return RenderAction.builder()
				.action(
						Action.builder().navigation(
								Navigation.builder().pushCard(
										Card.builder().header( Header.builder().title( "NDA Form" ).build() )
												.section(
														Section.builder().widget(
																TextParagraph.builder().text( "Please check for proper input!" ).build()
														).widget(
																TextInput.builder()
																		.label( "Name" )
																		.type( TextInput.type.SINGLE_LINE )
																		.name( "signerName" )
																		.build()
														).widget(
																TextInput.builder()
																		.label( "Email" )
																		.type( TextInput.type.SINGLE_LINE )
																		.name( "email" )
																		.build()
														).widget(
																TextInput.builder()
																		.label( "Company Name" )
																		.type( TextInput.type.SINGLE_LINE )
																		.name( "company" )
																		.build()
														).widget(
																TextInput.builder()
																		.label( "Address" )
																		.type( TextInput.type.SINGLE_LINE )
																		.name( "address" )
																		.build()
														).widget(
																DateTimePicker.builder()
																		.label( "Date" )
																		.type( DateTimePicker.type.DATE_ONLY )
																		.epochTimeMs( ( System.currentTimeMillis() ) )
																		.name( "date" )
																		.build()
														).widget(
																ButtonList.builder()
																		.button( Button.builder()
																				.text( "Submit Form" )
																				.color( Color.builder().red( (float) 0.38 ).green( (float) 0.765 ).blue( (float) 0.762 ).alpha( 1 ).build() )
																				.onClick( OnClick.builder()
																						.action( Action.builder()
																								.function( "https://" + SERVER_ROOT + "/landing/process/nda" )
																								//																								.parameter( Action.ActionParameters.builder().key( "action" ).value( "process/nda" ).build() )
																								.build() )
																						.build() )
																				.build()
																		).build()
														).build()
												).build()
								).build()
						).build()
				).build();
	}

	@RequestMapping( value = "/landing/process/nda", method = { RequestMethod.GET, RequestMethod.POST }, produces = "application/json" )
	public RenderAction processNDA( String signerName, String email, String company, String address, String date )
	{
		return RenderAction.builder()
				.action(
						Action.builder().navigation(
								Navigation.builder().pushCard(
										Card.builder().header( Header.builder().title( "NDA Form Created" ).build() )
												.section(
														Section.builder().widget( simpleText( "Name: " + signerName ) )
																.widget( simpleText( "Email: " + email ) )
																.widget( simpleText( "Company: " + company ) )
																.widget( simpleText( "Address: " + address ) )
																.widget( simpleText( "Date: " + date ) )
																.build()
												).build()
								).build()
						).build()
				).build();
	}
	
    /*--------------------------------------------
    |    N O N - P U B L I C    M E T H O D S   |
    ============================================*/

	private TextParagraph simpleText( String text )
	{
		return TextParagraph.builder().text( text ).build();
	}
	
    /*--------------------------------------------
    |  A C C E S S O R S / M O D I F I E R S    |
    ============================================*/
	
	/*--------------------------------------------
	|       I N L I N E    C L A S S E S        |
	============================================*/
}

