package com.oxos.google.addons.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class CardHeader
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String title;
	private String subtitle;

	private ImageType imageType;
	private String imageUrl;
	private String imageAltText;
}

