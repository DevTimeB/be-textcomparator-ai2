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

    public void saveTextHistoric(String text1, String text2, String similarity) {
        TextHistoric textHistoric = new TextHistoric(text1, text2, String.valueOf(similarity));
        service.saveTextHistoric(textHistoric);
    }

    public float compareTexts(TextRequest request) {
        String text1 = request.text1();
        String text2 = request.text2();

        Map<String, Integer> wordCount1 = countWords(text1);
        Map<String, Integer> wordCount2 = countWords(text2);

        float similarity = calculateCosineSimilarity(wordCount1, wordCount2);
        saveTextHistoric(text1, text2, String.valueOf(similarity));

        return similarity;
    }

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
