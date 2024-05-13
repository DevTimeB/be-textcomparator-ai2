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

@RestController
public class ComparatorController {

    @Autowired
    private ComparatorService comparatorService;
    @Autowired
    private TextHistoricService textHistoricService;

    @PostMapping("/compare")
    public ResponseEntity<String> compareTexts(@RequestBody TextRequest request) {
        float similarity = comparatorService.compareTexts(request);
        return new ResponseEntity<>("Similarity: " + similarity, HttpStatus.OK);
    }

    @GetMapping("/text-histories")
    public ResponseEntity<List<TextHistoric>> getAllTextHistories() {
        List<TextHistoric> textHistories = textHistoricService.getAllTextHistories();
        return new ResponseEntity<>(textHistories, HttpStatus.OK);
    }
}
