package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class CreateDocumentRequest {

    @JsonProperty("DocumentName")
    private String documentName;

    @JsonProperty("Content")
    List<DocumentContent> documentContentList;
}
