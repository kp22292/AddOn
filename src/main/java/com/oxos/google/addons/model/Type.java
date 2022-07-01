package com.oxos.google.addons.model;

import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class Type {

    private inputType type;
    public enum inputType {
        SINGLE_LINE,
        MULTIPLE_LINE
    }
}
