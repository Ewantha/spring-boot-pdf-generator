package com.eudagama12.example.pdfgenerator.controller;

import com.eudagama12.example.pdfgenerator.dto.CreateDocumentRequest;
import com.eudagama12.example.pdfgenerator.service.DocumentService;
import com.itextpdf.text.DocumentException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/document")
@Slf4j
public class DocumentController {

    final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Operation(summary = "Create a PDF Document")
    @PostMapping("/pdf")
    @ResponseStatus(HttpStatus.CREATED)
    public void generateDocument(@Valid @RequestBody CreateDocumentRequest createDocumentRequest) throws DocumentException, IOException {
        log.info("Received request: {}", createDocumentRequest);
        documentService.generatePDF(createDocumentRequest);
    }
}
