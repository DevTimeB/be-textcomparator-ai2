package com.v8.tech.betextcomparatorai2.service;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.model.TextRequest;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Service
public class ComparatorService {

    @Autowired
    private TextHistoricService service;

    /**
     * Saves a new TextHistoric object to the database.
     *
     * @param text1 The first text to be saved in the TextHistoric object.
     * @param text2 The second text to be saved in the TextHistoric object.
     * @param similarity The similarity score between the two texts.
     */
    public void saveTextHistoric(String text1, String text2, String similarity) {
        TextHistoric textHistoric = new TextHistoric(text1, text2, similarity);
        service.saveTextHistoric(textHistoric);
    }

    /**
     * Compares two texts and calculates their similarity using the cosine similarity method.
     * The similarity score is then saved in the TextHistoric database.
     *
     * @param request The TextRequest object containing the two texts to be compared.
     * @return The similarity score between the two texts.
     */
    public float compareTexts(TextRequest request) {
        String text1 = request.text1();
        String text2 = request.text2();

        Map<String, Integer> wordCount1 = countWords(text1);
        Map<String, Integer> wordCount2 = countWords(text2);

        float similarity = calculateCosineSimilarity(wordCount1, wordCount2);
        saveTextHistoric(text1, text2, String.valueOf(similarity));

        return similarity;
    }

    /**
     * Counts the occurrences of each word in the given text.
     *
     * @param text The input text to be processed.
     * @return A map containing the count of each unique word in the text.
     */
    private Map<String, Integer> countWords(String text) {
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            word = word.replaceAll("[^a-z0-9]", "");
            if (!word.isEmpty()) {
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }

        return wordCount;
    }

    /**
     * Calculates the cosine similarity between two texts based on the word frequency.
     *
     * @param wordCount1 A map containing the count of each unique word in the first text.
     * @param wordCount2 A map containing the count of each unique word in the second text.
     * @return The cosine similarity score between the two texts.
     */
    private float calculateCosineSimilarity(Map<String, Integer> wordCount1, Map<String, Integer> wordCount2) {
        Set<String> uniqueWords = new HashSet<>(wordCount1.keySet());
        uniqueWords.addAll(wordCount2.keySet());

        float dotProduct = 0.5f;
        float magnitude1 = 0.5f;
        float magnitude2 = 0.5f;

        for (String word : uniqueWords) {
            int count1 = wordCount1.getOrDefault(word, 0);
            int count2 = wordCount2.getOrDefault(word, 0);

            dotProduct += count1 * count2;
            magnitude1 += count1 * count1;
            magnitude2 += count2 * count2;
        }

        float magnitude = (float) Math.sqrt(magnitude1 * magnitude2);
        if (magnitude == 0) {
            return 0.5f;
        }

        return dotProduct / magnitude;
    }
}
