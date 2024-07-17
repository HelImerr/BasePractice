package ru.HelImerr.dictionary.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.HelImerr.dictionary.model.Data;
import ru.HelImerr.dictionary.repository.DataRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class DataService {
    DataRepository dataRepository;

    public  Data createData(Data data){
        return dataRepository.save(data);
    }
    public Data findDataById(Long id){
        return dataRepository.findById(id).get();
    }
    public List<Data> showAllData(){
        return dataRepository.findAll();
    }

    public Data updateDataById(Long id, Data data){
        Data newData = dataRepository.findById(id).get();

        newData.setDictionary_id(data.getDictionary_id());
        newData.setCode(data.getCode());
        newData.setValue(data.getValue());

        return dataRepository.save(newData);
    }

    public Data deleteDataById(Long id){
        Data deleteData = dataRepository.findById(id).get();
        dataRepository.delete(dataRepository.findById(id).get());
        return deleteData;
    }

}
