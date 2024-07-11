package ru.HelImerr.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.HelImerr.dictionary.model.Dictionary;
@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary, Long> {
}
