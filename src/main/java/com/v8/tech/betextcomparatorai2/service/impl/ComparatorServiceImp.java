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

    @Override
    public List<TextHistoric> getAllTextHistories() {
        return textHistoricRepository.findAll();
    }

    @Override
    public TextHistoric saveTextHistoric(TextHistoric textHistoric) {
        return textHistoricRepository.save(textHistoric);
    }

}
