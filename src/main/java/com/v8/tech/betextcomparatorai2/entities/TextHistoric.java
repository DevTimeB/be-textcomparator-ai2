package com.v8.tech.betextcomparatorai2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "text_historic")
@AllArgsConstructor
@NoArgsConstructor
public class TextHistoric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 140)
    private String text1;

    @Column(length = 140)
    private String text2;

    @Column(length = 140)
    private String similarity;
    public TextHistoric(String text1, String text2, String similarity) {
        this.text1 = text1;
        this.text2 = text2;
        this.similarity = similarity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }

    public String getSimilarity() {
        return similarity;
    }

    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
