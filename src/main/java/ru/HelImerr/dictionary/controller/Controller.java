package ru.HelImerr.dictionary.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.HelImerr.dictionary.model.Data;
import ru.HelImerr.dictionary.model.Dictionary;
import ru.HelImerr.dictionary.service.DataService;
import ru.HelImerr.dictionary.service.DictionaryService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/dictionaries", method = RequestMethod.GET)
public class Controller {
    private DataService dataService;
    private DictionaryService dictionaryService;

    //Методы удаления записей
    @PostMapping
    public Dictionary addDictionary(@RequestBody Dictionary dictionary) {
        return dictionaryService.createDictionary(dictionary);
    }

    @RequestMapping(path = "/data",method = RequestMethod.POST)
    public Data addData(@RequestBody Data data) {
        return dataService.createData(data);
    }

    //Методы удаления элементов
    @RequestMapping(path = "/del/{dictionaryId}",method = RequestMethod.DELETE)
    public Dictionary delDictionary(@PathVariable("dictionaryId") Long dictionaryId) {
        return dictionaryService.deleteDictionaryById(dictionaryId);
    }

    @RequestMapping(path = "/data/del/{dataId}",method = RequestMethod.DELETE)
    public Data delData(@PathVariable("dataId") Long dataId) {
        return dataService.deleteDataById(dataId);
    }

    //Метода получения конкретной записи
    @RequestMapping(path = "/dictionaryId",method = RequestMethod.GET)
    public Dictionary getDictionary(
            @PathVariable("dictionaryId") Long dictionaryId) {
        return dictionaryService.findDictionaryById(dictionaryId);
    }

    @RequestMapping(path = "/dataId",method = RequestMethod.DELETE)
    public Data getData(
            @PathVariable("dataId") Long dataId) {
        return dataService.findDataById(dataId);
    }

    //Методы получения всех записей
    @RequestMapping(path = "/alldictionary",method = RequestMethod.GET)
    public List<Dictionary> getAll_Dictionary() {

        return dictionaryService.showAllDictionary();
    }

    @RequestMapping(path = "/alldata",method = RequestMethod.GET)
    public List<Data> getAll_Data() {

        return dataService.showAllData();
    }

    //Методы изменения записей
    @RequestMapping(path = "/{dictionaryId}",method = RequestMethod.PUT)
    public Dictionary putDictionary(
            @PathVariable("dictionaryId")
            Long dictionaryId, @RequestBody Dictionary dictionary) {

        return dictionaryService.updateDictionaryById(dictionaryId, dictionary);

    }
    @RequestMapping(path = "/{dataId}",method = RequestMethod.PUT)
    public Data putData(
            @PathVariable("dataId")
            Long dataId, @RequestBody Data data) {

        return dataService.updateDataById(dataId, data);

    }
}
