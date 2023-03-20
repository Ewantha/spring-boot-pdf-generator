package com.eudagama12.example.pdfgenerator.service;

import com.eudagama12.example.pdfgenerator.dto.DocumentFontColor;
import com.eudagama12.example.pdfgenerator.dto.ElementFont;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * itext Font format util class
 */

@UtilityClass
@Slf4j
public class FontUtil {

    public static Font formatFont(ElementFont elementFont) {
        log.debug("Setting font");
        DocumentFontColor fontColor = elementFont.getDocumentFontColor();
        BaseColor baseColor = new BaseColor(fontColor.getRed(), fontColor.getGreen(), fontColor.getBlue());

        return FontFactory.getFont(elementFont.getFontType(), elementFont.getFontSize(),  elementFont.getFontStyle(), baseColor);
    }
}
