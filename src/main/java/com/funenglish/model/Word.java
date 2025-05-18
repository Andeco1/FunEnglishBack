package com.funenglish.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "words")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Слово на изучаемом языке */
    @Column(nullable = false)
    private String word;

    /** Перевод */
    @Column(nullable = false)
    private String translation;

    /** Группа/категория слова */
    @Column(name = "word_group", nullable = false)
    private String wordGroup;

    /** Пример использования */
    @Column(columnDefinition = "TEXT")
    private String example;
}