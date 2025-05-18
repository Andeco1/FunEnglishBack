package com.funenglish.service;

import com.funenglish.model.Word;
import com.funenglish.repository.WordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WordService {

    private final WordRepository repo;

    /** Возвращает все слова */
    @Transactional(readOnly = true)
    public List<Word> getAll() {
        return repo.findAll();
    }

    /** Возвращает слово по ID, либо бросает исключение */
    @Transactional(readOnly = true)
    public Word getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Word not found: " + id));
    }

    /** Список слов из указанной группы */
    @Transactional(readOnly = true)
    public List<Word> getByGroup(String group) {
        return repo.findByWordGroup(group);
    }

    /** Список всех уникальных групп */
    @Transactional(readOnly = true)
    public List<String> getGroups() {
        return repo.findDistinctWordGroups();
    }

    /** Создаёт новое слово */
    @Transactional
    public Word create(Word word) {
        return repo.save(word);
    }

    /** Создаёт несколько слов за раз */
    @Transactional
    public List<Word> createAll(List<Word> words) {
        return repo.saveAll(words);
    }
    @Transactional
    public Word update(Long id, Word updated) {
        Word existing = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Word not found: " + id));
        existing.setWord(updated.getWord());
        existing.setTranslation(updated.getTranslation());
        existing.setWordGroup(updated.getWordGroup());
        existing.setExample(updated.getExample());
        return repo.save(existing);
    }

    /** Удаляет слово по ID */
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}