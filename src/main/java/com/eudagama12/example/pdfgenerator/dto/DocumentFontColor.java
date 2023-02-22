package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class DocumentFontColor {
    @JsonProperty("Red")
    int red;
    @JsonProperty("Green")
    int green;
    @JsonProperty("Blue")
    int blue;
}
