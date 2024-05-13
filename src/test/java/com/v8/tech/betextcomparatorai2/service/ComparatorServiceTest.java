package com.v8.tech.betextcomparatorai2.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.model.TextRequest;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ComparatorServiceTest {

    @Mock
    private TextHistoricRepository textHistoricRepository;

    @Mock
    private TextHistoricService textHistoricService;

    @InjectMocks
    private ComparatorService comparatorService;

    @Test
    void testSaveTextHistoric() {
        String text1 = "Hello";
        String text2 = "World";
        String similarity = "0.5";

        TextHistoric textHistoric = new TextHistoric(text1, text2, similarity);
        when(textHistoricService.saveTextHistoric(any())).thenReturn(textHistoric);

        comparatorService.saveTextHistoric(text1, text2, similarity);
    }

    @Test
    void testCompareTexts() {
        String text1 = "The quick brown fox jumps over the lazy dog.";
        String text2 = "The dog jumps over the lazy fox.";
        float expectedSimilarity = 0.9088932871818542f;

        TextRequest request = new TextRequest(text1, text2);
        when(textHistoricService.saveTextHistoric(any())).thenReturn(new TextHistoric(text1, text2, String.valueOf(expectedSimilarity)));

        float actualSimilarity = comparatorService.compareTexts(request);

        assertEquals(expectedSimilarity, actualSimilarity, 0.000000000000001);
    }

}