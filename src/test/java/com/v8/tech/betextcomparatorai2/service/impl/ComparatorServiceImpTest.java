package com.v8.tech.betextcomparatorai2.service.impl;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import com.v8.tech.betextcomparatorai2.service.TextHistoricService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link ComparatorServiceImp}.
 */
@ExtendWith(MockitoExtension.class)
public class ComparatorServiceImpTest {

    /**
     * Mock of the {@link TextHistoricRepository}.
     */
    @Mock
    private TextHistoricRepository textHistoricRepository;

    /**
     * The {@link ComparatorServiceImp} instance to be tested.
     */
    @InjectMocks
    private ComparatorServiceImp comparatorServiceImp;

    /**
     * A sample {@link TextHistoric} object.
     */
    private TextHistoric textHistoric;

    /**
     * A list of {@link TextHistoric} objects.
     */
    private List<TextHistoric> textHistorics;

    /**
     * Initializes the test environment by setting up the necessary objects.
     */
    @BeforeEach
    void setUp() {
        textHistoric = new TextHistoric("Sample text 1", "Sample text 1", "1");
        textHistorics = Arrays.asList(textHistoric);
    }

    /**
     * Tests that {@link ComparatorServiceImp#getAllTextHistories()} returns all text histories when called.
     */
    @Test
    void getAllTextHistories_whenCalled_returnsAllTextHistories() {
        // Given
        when(textHistoricRepository.findAll()).thenReturn(textHistorics);

        // When
        List<TextHistoric> result = comparatorServiceImp.getAllTextHistories();

        // Then
        assertEquals(textHistorics, result);
    }

    /**
     * Tests that {@link ComparatorServiceImp#saveTextHistoric(TextHistoric)} saves a text history and returns it.
     */
    @Test
    void saveTextHistoric_whenCalled_savesTextHistoricAndReturnsIt() {
        // Given
        when(textHistoricRepository.save(textHistoric)).thenReturn(textHistoric);

        // When
        TextHistoric result = comparatorServiceImp.saveTextHistoric(textHistoric);

        // Then
        assertNotNull(result);
        assertEquals(textHistoric, result);
    }
}