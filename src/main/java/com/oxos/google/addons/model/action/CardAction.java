package com.oxos.google.addons.model.action;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Data
@JsonInclude( JsonInclude.Include.NON_NULL )
public class CardAction extends BaseAction
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String actionLabel;

	private OnClick onClick;
}

