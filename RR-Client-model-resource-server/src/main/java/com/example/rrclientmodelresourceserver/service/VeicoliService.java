package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.SwaggerCodeGenerator.model.Automobile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToEntity;
import static com.example.rrclientmodelresourceserver.converter.AutomobileConverter.convertToSwaggerSchema;

@Service
public class VeicoliService {

    private static final Logger logger = LoggerFactory.getLogger(VeicoliService.class);

    @Autowired
    private AutomobileRepository automobileRepository;

    public Automobile veicoliIdGet(Integer id){
        logger.info("VeicoliIdGet-service"); //logger
        if (id < 0) { //se l'id è minore di 0
            throw new IllegalArgumentException("id non può essere negativo"); //lancio un'eccezione catturata dal global exception handler
        }
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null); //cerco l'automobile con l'id passato e se non la trovo ritorno null
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }
        return convertToSwaggerSchema(automobileEntity); //ritorno l'automobile convertita in swagger schema
    }

    public Automobile veicoliAmministratoriInserimentoPost(Automobile automobile){
        logger.info("VeicoliAmministratoriInserimentoPost-service"); //logger
        automobileRepository.save(convertToEntity(automobile)); //salvo l'automobile convertita in entity
        return automobile; //ritorno l'automobile
    }

    public Automobile veicoliAmministratoriModificaIdPut(Integer id, Automobile automobile){
        logger.info("VeicoliAmministratoriModificaIdPut-service"); //logger
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null); //cerco l'automobile con l'id passato e se non la trovo ritorno null
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }
        //setto i campi dell'automobile con i campi dell'automobile passata
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

        automobileRepository.save(automobileEntity); //salvo l'automobile aggiornando quella gia presente nel database
        return automobile; //ritorno l'automobile
    }

    public String veicoliAmministratoriEliminaIdDelete(Integer id){
        logger.info("VeicoliAmministratoriEliminaIdDelete-service"); //logger
        if (id < 0) { //se l'id è minore di 0
            throw new IllegalArgumentException("id non può essere negativo"); //lancio un'eccezione catturata dal global exception handler
        }
        AutomobileEntity automobileEntity = automobileRepository.findById(id).orElse(null); //cerco l'automobile con l'id passato e se non la trovo ritorno null
        if(automobileEntity == null){
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }
        automobileRepository.delete(automobileEntity); //elimino l'automobile
        return "Automobile eliminata"; //ritorno un messaggio di successo
    }


    @Transactional
    public List<Automobile> veicoliAmministratoriNoleggioGet(){
        logger.info("VeicoliAmministratoriNoleggioGet-service"); //logger
        List<Automobile> automobili_noleggio= new ArrayList<>(); //creo una lista di automobili
        for (AutomobileEntity automobile : automobileRepository.veicoliNoleggioGet()) { //per ogni automobile presente nel database presa tramite la query hql
            automobili_noleggio.add(convertToSwaggerSchema(automobile)); //aggiungo l'automobile alla lista
        }
      return automobili_noleggio; //ritorno la lista
    }


    @Transactional
    public List<Automobile> veicoliAmministratoriAcquistoGet(){
        logger.info("VeicoliAmministratoriAcquistoGet-service"); //logger
        List<Automobile> automobili_acquisto= new ArrayList<>(); //creo una lista di automobili
        for (AutomobileEntity automobile : automobileRepository.veicoliAcquistoGet()) { //per ogni automobile presente nel database presa tramite la query hql
            automobili_acquisto.add(convertToSwaggerSchema(automobile)); //aggiungo l'automobile alla lista
        }
        return automobili_acquisto; //ritorno la lista
    }

    @Transactional
    public List<Automobile> veicoliClientiAcquistoGet(){
        logger.info("VeicoliClientiAcquistoGet-service"); //logger
        List<Automobile> automobili_acquisto= new ArrayList<>(); //creo una lista di automobili
        for (AutomobileEntity automobile : automobileRepository.veicoliAcquistoGet()) { //per ogni automobile presente nel database presa tramite la query hql
            automobili_acquisto.add(convertToSwaggerSchema(automobile)); //aggiungo l'automobile alla lista
        }
        return automobili_acquisto; //ritorno la lista
    }

    @Transactional
    public List<Automobile> veicoliClientiNoleggioGet(){
        logger.info("VeicoliClientiNoleggioGet-service"); //logger
        List<Automobile> automobili_noleggio= new ArrayList<>(); //creo una lista di automobili
        for (AutomobileEntity automobile : automobileRepository.veicoliNoleggioGet()) { //per ogni automobile presente nel database presa tramite la query hql
            automobili_noleggio.add(convertToSwaggerSchema(automobile)); //aggiungo l'automobile alla lista
        }
        return automobili_noleggio; //ritorno la lista
    }

}
