package com.oxos.google.addons.model.widget.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.oxos.google.addons.model.navigation.Action;
import com.oxos.google.addons.model.widget.base.BaseWidget;
import lombok.Builder;
import lombok.Data;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Log
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeName( "dateTimePicker" )
public class DateTimePicker extends BaseWidget
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String label;
	private DateTimePicker.type type;
	private String name;

	@JsonProperty( "valueMsEpoch" )
	private long epochTimeMs;

	private Integer timezoneOffsetDate;

	private Action onChangeAction;

	public enum type
	{
		DATE_AND_TIME,
		DATE_ONLY,
		TIME_ONLY
	}
}

