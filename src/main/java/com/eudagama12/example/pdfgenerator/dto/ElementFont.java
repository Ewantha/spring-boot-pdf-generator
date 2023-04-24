package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElementFont {
    @JsonProperty(value = "Type")
    private String fontType;

    @JsonProperty(value = "Size")
    private int fontSize;

    @JsonProperty(value = "Style")
    private int fontStyle;

    @JsonProperty("Color")
    private DocumentFontColor documentFontColor = new DocumentFontColor(0, 0, 0);
}
