package com.v8.tech.betextcomparatorai2.service.impl;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import com.v8.tech.betextcomparatorai2.repositories.TextHistoricRepository;
import com.v8.tech.betextcomparatorai2.service.TextHistoricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComparatorServiceImp implements TextHistoricService {

    @Autowired
    private TextHistoricRepository textHistoricRepository;

    /**
     * Retrieves all TextHistoric entities from the database.
     *
     * @return a list of all TextHistoric entities.
     */
    @Override
    public List<TextHistoric> getAllTextHistories() {
        return textHistoricRepository.findAll();
    }

    /**
     * Saves a new TextHistoric entity to the database.
     *
     * @param textHistoric the TextHistoric entity to be saved.
     * @return the saved TextHistoric entity.
     */
    @Override
    public TextHistoric saveTextHistoric(TextHistoric textHistoric) {
        return textHistoricRepository.save(textHistoric);
    }

}
