package com.funenglish.repository;

import com.funenglish.model.Word;
import com.funenglish.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    /** Все слова, отсортированные по id */
    List<Word> findAllByOrderByIdAsc();

    /** Слова из заданной группы */
    List<Word> findByWordGroup(String wordGroup);

    /** Список уникальных названий групп */
    @Query("SELECT DISTINCT w.wordGroup FROM Word w ORDER BY w.wordGroup ASC")
    List<String> findDistinctWordGroups();
}