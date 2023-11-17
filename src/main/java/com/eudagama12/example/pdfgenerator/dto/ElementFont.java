package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.text.FontFactory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ElementFont {
    @Schema(description = "Font type", allowableValues = {FontFactory.COURIER, FontFactory.COURIER_BOLD, FontFactory.COURIER_OBLIQUE, FontFactory.COURIER_BOLDOBLIQUE,
            FontFactory.HELVETICA, FontFactory.HELVETICA_BOLD, FontFactory.HELVETICA_OBLIQUE, FontFactory.HELVETICA_BOLDOBLIQUE, FontFactory.SYMBOL,
            FontFactory.TIMES, FontFactory.TIMES_ROMAN, FontFactory.TIMES_BOLD, FontFactory.TIMES_ITALIC, FontFactory.TIMES_BOLDITALIC, FontFactory.ZAPFDINGBATS},
    defaultValue = FontFactory.HELVETICA)
    @JsonProperty(value = "Type")
    private String fontType;

    @Schema(description = "Font size", defaultValue = "12")
    @JsonProperty(value = "Size")
    private int fontSize;

    @Schema(description = "Font style. Normal:0, Bold:1, Italic:2, Underline:4, Strikethrough:8, Bold-Italic:3", defaultValue = "0")
    @JsonProperty(value = "Style")
    private int fontStyle;

    @JsonProperty("Color")
    private DocumentFontColor documentFontColor = new DocumentFontColor(0, 0, 0);
}
