package com.oxos.google.addons.model.widget;

import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Getter
@JsonTypeName("textParagraph")
public class TextParagraph extends BaseWidget
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/	

	String text;
}

