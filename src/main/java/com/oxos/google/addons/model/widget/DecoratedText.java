package com.oxos.google.addons.model.widget;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oxos.google.addons.model.Icon;
import com.oxos.google.addons.model.action.OnClick;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeName("decoratedText")
public class DecoratedText extends BaseWidget
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	Icon startIcon;

	String topLabel;
	String text;

	boolean wrapText;

	String bottomLabel;

	OnClick onClick;

	Icon endIcon;
}

