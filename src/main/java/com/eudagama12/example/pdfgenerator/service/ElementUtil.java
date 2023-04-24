package com.eudagama12.example.pdfgenerator.service;

import com.eudagama12.example.pdfgenerator.dto.DocumentContent;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

import static com.eudagama12.example.pdfgenerator.service.FontUtil.formatFont;

/**
 * itext element initialization util class. Initialized elements will be added to List and returned.
 */

@UtilityClass
@Slf4j
public class ElementUtil {

    private static final String IMAGE_LOCAL_PATH = "data/img/";

    public static void addWhitespaceElement(List<Element> elementLinkedList) {
        log.debug("Found whitespace element");
        Chunk chunk = new Chunk("\n");
        elementLinkedList.add(chunk);
    }

    public static void addImageElement(List<Element> elementLinkedList, DocumentContent documentContent) {
        try {
            log.debug("Found image element");
            Image image = Image.getInstance(IMAGE_LOCAL_PATH + documentContent.getReference());
            if (documentContent.getScale() != null) {
                image.scalePercent(documentContent.getScale());
            }
            elementLinkedList.add(image);
        } catch (BadElementException e) {
            log.error("Failed to add image element. Bad element exception: {}", e.getMessage());
        } catch (IOException e) {
            log.error("Failed to add image element. File not found exception: {}", e.getMessage());
        }
    }

    public static void addTableElement(List<Element> elementLinkedList, DocumentContent documentContent) {
        try {
            log.debug("Found table element");
            Font tableFont = formatFont(documentContent.getElementFont());
            PdfPTable table = new PdfPTable(documentContent.getColumns()); // table columns
            table.setWidthPercentage(documentContent.getScale()); // table width to 100% of page width
            table.setSpacingBefore(10f); // space before table
            table.setSpacingAfter(10f); // space after table

            if (documentContent.getHeaderData() != null) {  //For heading
                Font headerTableFont = formatFont(documentContent.getHeaderFont());

                for (String cellData : documentContent.getHeaderData()) {
                    PdfPCell cell = new PdfPCell(new Paragraph(cellData, headerTableFont));
                    table.addCell(cell);
                }
            }

            for (String cellData : documentContent.getData()) {
                PdfPCell cell = new PdfPCell(new Paragraph(cellData, tableFont));
                table.addCell(cell);
            }

            elementLinkedList.add(table);
        } catch (Exception e) {
            log.error("Failed to add table element: {}", e.toString());
        }
    }

    public static void addAnchorElement(List<Element> elementLinkedList, DocumentContent documentContent) {
        try {
            log.debug("Found anchor element");
            Anchor anchor = new Anchor(documentContent.getText() + "\n", formatFont(documentContent.getElementFont()));
            anchor.setReference(documentContent.getReference());
            elementLinkedList.add(anchor);
        } catch (Exception e) {
            log.error("Failed to add anchor element: {}", e.toString());
        }
    }

    public static void addParagraphElement(List<Element> elementLinkedList, DocumentContent documentContent) {
        try {
            log.debug("Found paragraph element");
            Paragraph paragraph = new Paragraph(documentContent.getText(), formatFont(documentContent.getElementFont()));
            elementLinkedList.add(paragraph);
        } catch (Exception e) {
            log.error("Failed to add paragraph element: {}", e.toString());
        }
    }
}
