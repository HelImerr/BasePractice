package ru.HelImerr.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.HelImerr.dictionary.model.Dictionary;
import ru.HelImerr.dictionary.repository.DictionaryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DictionaryService {
    DictionaryRepository dictionaryRepository;

    public Dictionary createDictionary(Dictionary Dictionary){
        return dictionaryRepository.save(Dictionary);
    }
    public Dictionary findDictionaryById(Long id){
        return dictionaryRepository.findById(id).get();
    }
    public List<Dictionary> showAllDictionary(){
        return dictionaryRepository.findAll();
    }

    public Dictionary updateDictionaryById(Long id, Dictionary dictionary){
        Dictionary newDictionary = dictionaryRepository.findById(id).get();

        newDictionary.setCode(dictionary.getCode());
        newDictionary.setDescription(dictionary.getDescription());

        dictionaryRepository.save(newDictionary);
        return newDictionary;
    }

    public Dictionary deleteDictionaryById(Long id){
        Dictionary deleteDictionary = dictionaryRepository.findById(id).get();
        dictionaryRepository.delete(dictionaryRepository.findById(id).get());
        return deleteDictionary;
    }

}