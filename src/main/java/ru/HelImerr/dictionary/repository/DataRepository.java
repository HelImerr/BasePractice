package ru.HelImerr.dictionary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.HelImerr.dictionary.model.Data;
@Repository
public interface DataRepository extends JpaRepository<Data,Long> {
}
