package com.oxos.google.addons.model.navigation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.google.api.client.util.Lists;
import com.oxos.google.addons.model.action.OnClick;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_EMPTY )
@JsonTypeName("action")
public class Action
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String function;

	@JsonProperty("parameters")
	@Singular( "parameter" )
	private List<ActionParameters> actionParameterList;

	private LoadIndicator loadIndicator;

	private Boolean persistValues;

	@JsonProperty("navigations")
	@Singular( "navigation" )
	private List<Navigation> navigationList;
	
	/*--------------------------------------------
	|       I N L I N E    C L A S S E S        |
	============================================*/

	@Data
	@Builder
	public static class ActionParameters
	{
		String key;
		String value;
	}

	public enum LoadIndicator
	{
		SPINNER, NONE;
	}


}

