package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToEntity;
import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToSwaggerSchema;

@Service
public class AutomobileService {

    @Autowired
    private AutomobileRepository automobileRepository;

    public Automobile veicoliIdGet(Integer id){
        //controlla se id passato è un numero altrimenti manda l'eccezione
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null);
        assert automobileEntity != null;
        return convertToSwaggerSchema(automobileEntity);
    }

    public Automobile veicoliAmministratoriInserimentoPost(Automobile automobile){
        automobileRepository.save(convertToEntity(automobile));
        return automobile;
    }

}
