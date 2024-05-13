package com.v8.tech.betextcomparatorai2.controller;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.model.TextRequest;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import com.v8.tech.betextcomparatorai2.service.ComparatorService;
import com.v8.tech.betextcomparatorai2.service.TextHistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller class for handling text comparison and retrieving text histories.
 *
 * @author Dev001B
 * @version 1.0
 */
@RestController
public class ComparatorController {

    /**
     * Autowired instance of ComparatorService for text comparison.
     */
    @Autowired
    private ComparatorService comparatorService;

    /**
     * Autowired instance of TextHistoricService for handling text histories.
     */
    @Autowired
    private TextHistoricService textHistoricService;

    /**
     * Endpoint for comparing two texts and returning their similarity score.
     *
     * @param request The TextRequest object containing the two texts to compare.
     * @return A ResponseEntity containing a string with the similarity score.
     */
    @PostMapping("/compare")
    public ResponseEntity<String> compareTexts(@RequestBody TextRequest request) {
        float similarity = comparatorService.compareTexts(request);
        return new ResponseEntity<>("Similarity: " + similarity, HttpStatus.OK);
    }

    /**
     * Endpoint for retrieving all text histories.
     *
     * @return A ResponseEntity containing a list of TextHistoric objects representing all text histories.
     */
    @GetMapping("/text-histories")
    public ResponseEntity<List<TextHistoric>> getAllTextHistories() {
        List<TextHistoric> textHistories = textHistoricService.getAllTextHistories();
        return new ResponseEntity<>(textHistories, HttpStatus.OK);
    }
}
