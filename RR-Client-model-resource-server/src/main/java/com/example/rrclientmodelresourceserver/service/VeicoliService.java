package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToEntity;
import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToSwaggerSchema;

@Service
public class VeicoliService {

    @Autowired
    private AutomobileRepository automobileRepository;

    public Automobile veicoliIdGet(Integer id){
        if (id < 0) {
            throw new IllegalArgumentException("id non può essere negativo");
        }
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null);
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database");
        }
        return convertToSwaggerSchema(automobileEntity);
    }

    public Automobile veicoliAmministratoriInserimentoPost(Automobile automobile){
        automobileRepository.save(convertToEntity(automobile));
        return automobile;
    }

    public Automobile veicoliAmministratoriModificaIdPut(Integer id, Automobile automobile){
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null);
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database");
        }
        automobileEntity.setMarca(automobile.getMarca());
        automobileEntity.setModello(automobile.getModello());
        automobileEntity.setPrezzoAcquisto(automobile.getPrezzoAcquisto().doubleValue());
        automobileEntity.setPrezzoNoleggioGiornaliero(automobile.getPrezzoNoleggioGiornaliero().doubleValue());
        automobileEntity.setDisponibile(automobile.getDisponibile());
        automobileEntity.setQuantita(automobile.getQuantita().intValue());
        automobileEntity.setCavalli(automobile.getCavalli().intValue());
        automobileEntity.setCilindrata(automobile.getCilindrata().doubleValue());
        automobileEntity.setPostiASedere(automobile.getPostiASedere().intValue());
        automobileEntity.setCarburante(automobile.getCarburante());
        automobileEntity.setTarga(automobile.getTarga());
        automobileEntity.setTipoDiDestinazione(automobile.getTipoDiDestinazione());

        automobileRepository.save(automobileEntity);
        return automobile;
    }

    public String veicoliAmministratoriEliminaIdDelete(Integer id){
        if (id < 0) {
            throw new IllegalArgumentException("id non può essere negativo");
        }
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null);
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database");
        }
        automobileRepository.delete(automobileEntity);
        return "Automobile eliminata";
    }

}
