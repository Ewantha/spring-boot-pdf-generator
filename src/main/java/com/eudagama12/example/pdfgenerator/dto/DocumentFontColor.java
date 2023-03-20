package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DocumentFontColor {
    @JsonProperty(value = "Red")
    int red;
    @JsonProperty(value = "Green")
    int green;
    @JsonProperty(value = "Blue")
    int blue;
}
