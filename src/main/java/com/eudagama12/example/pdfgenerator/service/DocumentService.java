package com.eudagama12.example.pdfgenerator.service;

import com.eudagama12.example.pdfgenerator.dto.CreateDocumentRequest;
import com.eudagama12.example.pdfgenerator.dto.DocumentContent;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

import static com.eudagama12.example.pdfgenerator.service.ElementUtil.*;

@Service
@Getter
@Setter
@Slf4j
public class DocumentService {

    @Value("${localPath.pdf}")
    private String pdfLocalPath;

    public void generatePDF(CreateDocumentRequest createDocumentRequest) throws IOException, DocumentException {
        log.debug("Initiate PDF");
        String pdfFile = createDocumentRequest.getDocumentName() + ".pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(pdfLocalPath + pdfFile)));
        log.info("Created PDF: {}", pdfFile);

        document.open();

        //Init user requested elements
        LinkedList<Element> elements = initializeDocumentElement(createDocumentRequest.getDocumentContentList());

        //Adding user requested elements
        for (Element element : elements) {
            document.add(element);
        }

        document.close();
    }

    private LinkedList<Element> initializeDocumentElement(List<DocumentContent> documentOrderContentList) {
        LinkedList<Element> elementLinkedList = new LinkedList<>();

        for (DocumentContent documentContent : documentOrderContentList) {
            switch (documentContent.getType()) {
                case "Paragraph":
                    addParagraphElement(elementLinkedList, documentContent);
                    break;
                case "Anchor":
                    addAnchorElement(elementLinkedList, documentContent);
                    break;
                case "Image":
                    addImageElement(elementLinkedList, documentContent);
                    break;
                case "Table":
                    addTableElement(elementLinkedList, documentContent);
                    break;
                case "Whitespace":
                    addWhitespaceElement(elementLinkedList);
                    break;
                default:
                    log.error("Unknown element type: {}", documentContent.getType());

            }
        }

        return elementLinkedList;
    }
}
