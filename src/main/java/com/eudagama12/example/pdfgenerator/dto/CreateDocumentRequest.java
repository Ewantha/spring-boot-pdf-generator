package com.eudagama12.example.pdfgenerator.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Getter
@Setter
@ToString
public class CreateDocumentRequest {

    @NotBlank(message = "Document name cannot be blank")
    @Schema(description = "Name of the PDF document", example = "HelloWorld", required = true)
    @JsonProperty("DocumentName")
    private String documentName;

    @JsonProperty("Content")
    List<DocumentContent> documentContentList;
}
