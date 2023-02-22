package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ElementFont {
    @JsonProperty("Type")
    private String fontType;

    @JsonProperty("Size")
    private int fontSize;

    @JsonProperty("Color")
    private DocumentFontColor documentFontColor;
}
