package com.v8.tech.betextcomparatorai2.controller;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.model.TextRequest;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import com.v8.tech.betextcomparatorai2.service.ComparatorService;
import com.v8.tech.betextcomparatorai2.service.TextHistoricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComparatorControllerTest {

    @Mock
    private TextHistoricService textHistoricService;

    @InjectMocks
    private ComparatorController comparatorController;

    @BeforeEach
    void setUp() {
        // Initialize any necessary mock objects or data here
    }

    @Test
    void testGetAllTextHistories_EmptyInput_ReturnsEmptyList() {
        // Arrange
        when(textHistoricService.getAllTextHistories()).thenReturn(Collections.emptyList());

        // Act
        ResponseEntity<List<TextHistoric>> result = comparatorController.getAllTextHistories();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(Collections.emptyList(), result.getBody());
    }

    @Test
    void testGetAllTextHistories_NullInput_ReturnsEmptyList() {
        // Arrange
        when(textHistoricService.getAllTextHistories()).thenReturn(null);

        // Act
        ResponseEntity<List<TextHistoric>> result = comparatorController.getAllTextHistories();

        // Assert
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals(null, result.getBody());
    }

}