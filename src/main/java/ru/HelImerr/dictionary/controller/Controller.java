package ru.HelImerr.dictionary.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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

    //Методы добавления записей
    @RequestMapping(path = "/dictionary")
    @Tag(name = "Добавление записи", description = "Добавление записи в таблицу dictionary, в тело запроса передать такие параметры как code(строка), description(строка), указывать идентификатор не требуется")
    public Dictionary addDictionary(@RequestBody Dictionary dictionary) {
        return dictionaryService.createDictionary(dictionary);
    }

    @RequestMapping(path = "/data",method = RequestMethod.POST)
    @Tag(name = "Добавление записи", description = "Добавление записи в таблицу data, в тело запроса передать такие параметры как dictionary_id(положительное целое число), code(строка), value(строка), указывать идентификатор не требуется")
    public Data addData(@RequestBody Data data) {
        return dataService.createData(data);
    }

    //Методы удаления элементов
    @RequestMapping(path = "/del/{dictionaryId}")
    @Tag(name = "Удаление записи", description = "Удаление записи из таблицы dictionary, айди записи указать в конце url, пример: dictionaries/1")
    public Dictionary delDictionary(@PathVariable("dictionaryId") Long dictionaryId) {
        return dictionaryService.deleteDictionaryById(dictionaryId);
    }

    @RequestMapping(path = "/data/del/{dataId}")
    @Tag(name = "Удаление записи", description = "Удаление записи из таблицы dictionary, айди записи указать в конце url, пример: dictionaries/data/1")
    public Data delData(@PathVariable("dataId") Long dataId) {
        return dataService.deleteDataById(dataId);
    }

    //Метода получения конкретной записи
    @RequestMapping(path = "/dictionary/{dictionaryId}",method = RequestMethod.GET)
    @Tag(name = "Получение записи", description = "Получение записи из таблицы dictionary основываясь на ее уникальном идентификаторе, тело запроса не запрашивается")
    public Dictionary getDictionary(
            @PathVariable("dictionaryId") Long dictionaryId) {
        return dictionaryService.findDictionaryById(dictionaryId);
    }

    @RequestMapping(path = "/data/{dataId}",method = RequestMethod.GET)
    @Tag(name = "Получение записи", description = "Получение записи из таблицы data основываясь на ее уникальном идентификаторе, тело запроса не запрашивается, айди искомой записи указать в конце url, пример: dictionaries/data/1")
    public Data getData(
            @PathVariable("dataId") Long dataId) {
        return dataService.findDataById(dataId);
    }

    //Методы получения всех записей
    @RequestMapping(path = "/alldictionary",method = RequestMethod.GET)
    @Tag(name = "Получение всех записей", description = "Получение всех записей из таблицы dictionary, тело запроса не запрашивается")
    public List<Dictionary> getAll_Dictionary() {

        return dictionaryService.showAllDictionary();
    }

    @RequestMapping(path = "/alldata",method = RequestMethod.GET)
    @Tag(name = "Получение всех записей", description = "Получение всех записей из таблицы data, тело запроса не запрашивается")
    public List<Data> getAll_Data() {

        return dataService.showAllData();
    }

    //Методы изменения записей

    @RequestMapping(path = "/update/dictionary/{dictionaryId}",method = RequestMethod.PUT)
    @Tag(name = "Изменение записи", description = "Изменение записи в таблице dictionary, в тело запроса передать такие параметры как code(строка), description(строка)")
    public Dictionary putDictionary(
            @PathVariable("dictionaryId")
            Long dictionaryId, @RequestBody Dictionary dictionary) {

        return dictionaryService.updateDictionaryById(dictionaryId, dictionary);

    }
    @RequestMapping(path = "/update/data/{dataId}",method = RequestMethod.PUT)
    @Tag(name = "Изменение записи", description = "Изменение записи в таблице data, в тело запроса передать такие параметры как dictionary_id(положительное целое число), code(строка), value(строка), айди изменяемой записи указать в конце url, пример: dictionaries/update/data/1")
    public Data putData(
            @PathVariable("dataId")
            Long dataId, @RequestBody Data data) {

        return dataService.updateDataById(dataId, data);

    }
}
