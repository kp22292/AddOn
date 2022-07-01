package com.oxos.google.addons.model.widget;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.Builder;
import lombok.Singular;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Builder
@JsonTypeName("buttonList")
public class ButtonList extends BaseWidget
{
    @JsonProperty( "buttons" )
    @Singular( "button" )
    private List<Button> buttonList;
}
