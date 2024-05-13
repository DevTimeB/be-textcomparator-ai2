package com.v8.tech.betextcomparatorai2.repositories;

import com.v8.tech.betextcomparatorai2.entities.TextHistoric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextHistoricRepository extends JpaRepository<TextHistoric, Long> {
}
