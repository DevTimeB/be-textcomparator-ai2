package com.v8.tech.betextcomparatorai2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Entity representing a pair of texts and their similarity.
 *
 * @author Tabnine
 */
@Entity
@Table(name = "text_historic")
@AllArgsConstructor
@NoArgsConstructor
public class TextHistoric {
    /**
     * The unique identifier for the text pair.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The first text in the pair.
     *
     * @param text1 the text to set
     */
    @Column(length = 140)
    private String text1;

    /**
     * The second text in the pair.
     *
     * @param text2 the text to set
     */
    @Column(length = 140)
    private String text2;

    /**
     * The similarity score between the two texts.
     *
     * @param similarity the similarity to set
     */
    @Column(length = 140)
    private String similarity;

    /**
     * Constructor for creating a new TextHistoric entity.
     *
     * @param text1 the first text
     * @param text2 the second text
     * @param similarity the similarity score
     */
    public TextHistoric(String text1, String text2, String similarity) {
        this.text1 = text1;
        this.text2 = text2;
        this.similarity = similarity;
    }

    /**
     * Getter for the unique identifier.
     *
     * @return the unique identifier
     */
    public Long getId() {
        return id;
    }

    /**
     * Setter for the unique identifier.
     *
     * @param id the unique identifier to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Getter for the first text in the pair.
     *
     * @return the first text
     */
    public String getText1() {
        return text1;
    }

    /**
     * Setter for the first text in the pair.
     *
     * @param text1 the first text to set
     */
    public void setText1(String text1) {
        this.text1 = text1;
    }

    /**
     * Getter for the second text in the pair.
     *
     * @return the second text
     */
    public String getText2() {
        return text2;
    }

    /**
     * Setter for the second text in the pair.
     *
     * @param text2 the second text to set
     */
    public void setText2(String text2) {
        this.text2 = text2;
    }

    /**
     * Getter for the similarity score.
     *
     * @return the similarity score
     */
    public String getSimilarity() {
        return similarity;
    }

    /**
     * Setter for the similarity score.
     *
     * @param similarity the similarity score to set
     */
    public void setSimilarity(String similarity) {
        this.similarity = similarity;
    }
}
