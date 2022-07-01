package com.oxos.google.addons.model;

import com.fasterxml.jackson.annotation.*;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

@Slf4j
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude( JsonInclude.Include.NON_NULL )
public class Section
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	String header;

	@JsonProperty( "widgets" )
	@Singular( "widget" )
	private List<BaseWidget> widgetList;
}

