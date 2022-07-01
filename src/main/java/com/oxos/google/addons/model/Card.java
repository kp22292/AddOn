package com.oxos.google.addons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.oxos.google.addons.model.action.CardAction;
import com.oxos.google.addons.model.widget.ButtonList;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

  Header header;

  @JsonProperty("sections")
  @Singular("section")
  List<Section> sectionList;

  @JsonProperty("cardActions")
  @Singular("cardAction")
  List<CardAction> cardActionList;

  private String name;

  private CardFixedFooter cardFixedFooter;

  private DisplayStyle displayStyle;
	
	/*--------------------------------------------
	|       I N L I N E    C L A S S E S        |
	============================================*/

  @Data
  @Builder
  public static class CardFixedFooter {
    ButtonList primaryButton;
    ButtonList secondaryButton;
  }

  public enum DisplayStyle {
    DISPLAY_STYLE_UNSPECIFIED, PEEK, REPLACE;
  }
}

