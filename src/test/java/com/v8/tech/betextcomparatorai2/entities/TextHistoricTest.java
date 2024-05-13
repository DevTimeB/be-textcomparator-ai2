package com.v8.tech.betextcomparatorai2.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TextHistoricTest {

    @Test
    void testTextHistoric_LongTexts() {
        String longText1 = "This is a very long text that exceeds the length limit of 140 characters.";
        String longText2 = "This is another very long text that also exceeds the length limit of 140 characters.";
        String longSimilarity = "This is a very long similarity score that exceeds the length limit of 140 characters.";

        TextHistoric textHistoric = new TextHistoric(longText1, longText2, longSimilarity);

        assertNotNull(textHistoric.getText1());
        assertNotNull(textHistoric.getText2());
        assertNotNull(textHistoric.getSimilarity());

        assertEquals(longText1, textHistoric.getText1());
        assertEquals(longText2, textHistoric.getText2());
        assertEquals(longSimilarity, textHistoric.getSimilarity());
    }

    @Test
    void testTextHistoric_LongText1_NormalText2_Similarity() {
        String longText1 = "This is a very long text that exceeds the length limit of 140 characters.";
        String normalText2 = "This is a normal length text that does not exceed the length limit.";
        String normalSimilarity = "This is a normal length similarity score that does not exceed the length limit.";

        TextHistoric textHistoric = new TextHistoric(longText1, normalText2, normalSimilarity);

        assertNotNull(textHistoric.getText1());
        assertNotNull(textHistoric.getText2());
        assertNotNull(textHistoric.getSimilarity());

        assertEquals(longText1, textHistoric.getText1());
        assertEquals(normalText2, textHistoric.getText2());
        assertEquals(normalSimilarity, textHistoric.getSimilarity());
    }

    @Test
    void testTextHistoric_NormalText1_LongText2_Similarity() {
        String normalText1 = "This is a normal length text that does not exceed the length limit.";
        String longText2 = "This is a very long text that exceeds the length limit of 140 characters.";
        String normalSimilarity = "This is a normal length similarity score that does not exceed the length limit.";

        TextHistoric textHistoric = new TextHistoric(normalText1, longText2, normalSimilarity);

        assertNotNull(textHistoric.getText1());
        assertNotNull(textHistoric.getText2());
        assertNotNull(textHistoric.getSimilarity());

        assertEquals(normalText1, textHistoric.getText1());
        assertEquals(longText2, textHistoric.getText2());
        assertEquals(normalSimilarity, textHistoric.getSimilarity());
    }

    @Test
    void testTextHistoric_NormalText1_NormalText2_LongSimilarity() {
        String normalText1 = "This is a normal length text that does not exceed the length limit.";
        String normalText2 = "This is a normal length text that does not exceed the length limit.";
        String longSimilarity = "This is a very long similarity score that exceeds the length limit of 140 characters.";

        TextHistoric textHistoric = new TextHistoric(normalText1, normalText2, longSimilarity);

        assertNotNull(textHistoric.getText1());
        assertNotNull(textHistoric.getText2());
        assertNotNull(textHistoric.getSimilarity());

        assertEquals(normalText1, textHistoric.getText1());
        assertEquals(normalText2, textHistoric.getText2());
        assertEquals(longSimilarity, textHistoric.getSimilarity());
    }

    @Test
    void testTextHistoric_LongText1_NormalText2_LongSimilarity() {
        String longText1 = "This is a very long text that exceeds the length limit of 140 characters.";
        String normalText2 = "This is a normal length text that does not exceed the length limit.";
        String longSimilarity = "This is a very long similarity score that exceeds the length limit of 140 characters.";

        TextHistoric textHistoric = new TextHistoric(longText1, normalText2, longSimilarity);

        assertNotNull(textHistoric.getText1());
        assertNotNull(textHistoric.getText2());
        assertNotNull(textHistoric.getSimilarity());

        assertEquals(longText1, textHistoric.getText1());
        assertEquals(normalText2, textHistoric.getText2());
        assertEquals(longSimilarity, textHistoric.getSimilarity());
    }
}