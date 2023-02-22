package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocumentContent {
    @JsonProperty(value = "Type")
    private String type;

    @JsonProperty("Font")
    private ElementFont elementFont;

    @JsonProperty(value = "Text")
    private String text;

    @JsonProperty(value = "Reference")  //For Anchor element
    private String reference;

}
