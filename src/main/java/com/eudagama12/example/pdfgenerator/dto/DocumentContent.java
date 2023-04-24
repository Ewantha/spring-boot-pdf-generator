package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.itextpdf.text.FontFactory;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class DocumentContent {
    @JsonProperty(value = "Type")
    private String type;

    @JsonProperty(value = "Font")
    private ElementFont elementFont = new ElementFont(FontFactory.HELVETICA, 12, 0, new DocumentFontColor(0, 0, 0));    //Default ElementFont object initialized for pre set

    @JsonProperty(value = "Text")
    private String text;

    @JsonProperty(value = "Reference")  //For Anchor element, image element
    private String reference;

    @JsonProperty(value = "Scale")  //For Image element, table element
    private Float scale;

    @JsonProperty(value = "Columns")    //For Table element
    private int columns;

    @JsonProperty(value = "Data")   //For Table element
    private List<String> data;

    @JsonProperty(value = "Header")   //For Table element
    private List<String> headerData;

    @JsonProperty(value = "HeaderFont")   //For Table element
    private ElementFont headerFont = new ElementFont(FontFactory.HELVETICA, 12, 1, new DocumentFontColor(0, 0, 0)); //Default ElementFont object initialized for pre set

}
