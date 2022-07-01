package com.oxos.google.addons.model.widget;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oxos.google.addons.model.Color;
import com.oxos.google.addons.model.Icon;
import com.oxos.google.addons.model.action.OnClick;
import com.oxos.google.addons.model.navigation.Action;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonTypeName("buttons")
public class Button {
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

  private String text;
  private String altText;

  private Color color;
  private Icon icon;
  private OnClick onClick;
  private Action action;

  private boolean disabled;
}

