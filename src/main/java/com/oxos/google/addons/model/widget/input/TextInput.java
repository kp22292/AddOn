package com.oxos.google.addons.model.widget.input;

import com.fasterxml.jackson.annotation.JsonInclude;
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
@JsonTypeName( "textInput" )
public class TextInput extends BaseWidget
{
    /*--------------------------------------------
    |    I N S T A N C E   V A R I A B L E S    |
    ============================================*/

	private String label;
	private TextInput.type type;
	private String name;
	private String hintText;
	private String value;
	private Action onChangeAction;

	public enum type
	{
		SINGLE_LINE,
		MULTIPLE_LINE
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue( String value )
	{
		this.value = value;
	}
}

