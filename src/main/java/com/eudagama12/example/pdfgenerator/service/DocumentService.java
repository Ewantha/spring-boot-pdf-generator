package com.eudagama12.example.pdfgenerator.service;

import com.eudagama12.example.pdfgenerator.dto.*;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

@Service
@Getter
@Setter
@Slf4j
public class DocumentService {

    private Font font;

    public void generatePDF(CreateDocumentRequest createDocumentRequest) throws IOException, DocumentException {
        log.debug("Initiate PDF");
        String pdfFile = "src/main/resources/data/" + createDocumentRequest.getDocumentName() + ".pdf";

        Document document = new Document();
        PdfWriter.getInstance(document, Files.newOutputStream(Paths.get(pdfFile)));
        log.info("Created PDF: {}", pdfFile);

        font = defaultFont();
        log.info("Font set success");

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
            Font elementFont = font;
            switch (documentContent.getType()) {
                case "Paragraph":
                    log.info("Found paragraph element");
                    if (documentContent.getElementFont() != null) {
                        elementFont = formatFont(documentContent.getElementFont());
                    }
                    Paragraph paragraph = new Paragraph(documentContent.getText(), elementFont);
                    elementLinkedList.add(paragraph);
                    break;
                case "Anchor":
                    log.info("Found anchor element");
                    if (documentContent.getElementFont() != null) {
                        elementFont = formatFont(documentContent.getElementFont());
                    }
                    Anchor anchor = new Anchor(documentContent.getText() + "\n", elementFont);
                    anchor.setReference(documentContent.getReference());
                    elementLinkedList.add(anchor);
                    break;
                case "Whitespace":
                    log.info("Found whitespace element");
                    Chunk chunk = new Chunk("\n");
                    elementLinkedList.add(chunk);
                    break;
                default:
                    log.error("Unknown element type: {}", documentContent.getType());

            }
        }

        return elementLinkedList;
    }

    private static Font formatFont(ElementFont elementFont) {
        log.debug("Setting font");
        DocumentFontColor fontColor = elementFont.getDocumentFontColor();
        BaseColor baseColor = new BaseColor(fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue());

        return FontFactory.getFont(FontFactory.HELVETICA, elementFont.getFontSize(), baseColor);
    }

    private static Font defaultFont() {
        log.debug("Setting default font");
        return FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.BLACK);
    }

}
