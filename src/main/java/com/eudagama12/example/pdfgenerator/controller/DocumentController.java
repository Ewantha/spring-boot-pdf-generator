package com.eudagama12.example.pdfgenerator.controller;

import com.eudagama12.example.pdfgenerator.dto.CreateDocumentRequest;
import com.eudagama12.example.pdfgenerator.service.DocumentService;
import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/document")
@Slf4j
public class DocumentController {

    @Autowired
    DocumentService documentService;

    @PostMapping("/pdf")
    @ResponseStatus(HttpStatus.CREATED)
    public void generateDocument(@RequestBody CreateDocumentRequest createDocumentRequest) throws DocumentException, IOException {
        log.info("Received request: {}", createDocumentRequest);
        documentService.generatePDF(createDocumentRequest);
    }
}
