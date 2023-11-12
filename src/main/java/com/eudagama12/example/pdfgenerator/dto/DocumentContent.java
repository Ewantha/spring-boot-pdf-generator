package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.text.FontFactory;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DocumentContent {
    @Schema(description = "Type of document element to be created.",
            allowableValues = {"Paragraph", "Anchor", "Image", "Table", "Whitespace"},
            required = true)
    @JsonProperty(value = "Type")
    private String type;

    @Schema(description = "Custom font settings.",
            nullable = true)
    @JsonProperty(value = "Font")
    private ElementFont elementFont = new ElementFont(FontFactory.HELVETICA, 12, 0, new DocumentFontColor(0, 0, 0));    //Default ElementFont object initialized for pre set

    @Schema(description = "Input text.",
            example = "Lorem ipsum...")
    @JsonProperty(value = "Text")
    private String text;

    @Schema(description = "Only for anchor elements and image elements. Set url or image source.",
            example = "www.google.com")
    @JsonProperty(value = "Reference")  //For Anchor element, image element
    private String reference;

    @Schema(description = "Only for image and table elements.",
            example = "1.2")
    @JsonProperty(value = "Scale")  //For Image element, table element
    private Float scale;

    @Schema(description = "Only for table elements.",
            example = "2")
    @JsonProperty(value = "Columns")    //For Table element
    private int columns;

    @Schema(description = "Only for table elements.")
    @JsonProperty(value = "Data")   //For Table element
    private List<String> data;

    @Schema(description = "Only for table elements.")
    @JsonProperty(value = "Header")   //For Table element
    private List<String> headerData;

    @Schema(description = "Only for table elements.")
    @JsonProperty(value = "HeaderFont")   //For Table element
    private ElementFont headerFont = new ElementFont(FontFactory.HELVETICA, 12, 1, new DocumentFontColor(0, 0, 0)); //Default ElementFont object initialized for pre set

}
