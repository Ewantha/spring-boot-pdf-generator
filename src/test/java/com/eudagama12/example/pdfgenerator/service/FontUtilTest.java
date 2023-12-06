package com.eudagama12.example.pdfgenerator.service;

import com.eudagama12.example.pdfgenerator.dto.ElementFont;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FontUtilTest {

    @Mock(answer = Answers.RETURNS_DEEP_STUBS)
    ElementFont elementFont;

    @Test
    void formatFont() {
        assertNotNull(FontUtil.formatFont(elementFont));
    }
}