package com.oxos.google.addons.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import com.fasterxml.jackson.annotation.JsonTypeName;


@Slf4j
@Data
@Builder
@JsonInclude( JsonInclude.Include.NON_NULL )
@JsonTypeName("input")
public class inputSaver {
  public static String allInputs = "";

  public static String getAllInputs() {
    return allInputs;
  }

  public void setAllInputs(String allInputs) {
    this.allInputs = allInputs;
  }
}
