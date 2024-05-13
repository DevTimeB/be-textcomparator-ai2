package com.v8.tech.betextcomparatorai2.service;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;

import java.util.List;

public interface TextHistoricService {
    List<TextHistoric> getAllTextHistories();
    TextHistoric saveTextHistoric(TextHistoric textHistoric);
}
