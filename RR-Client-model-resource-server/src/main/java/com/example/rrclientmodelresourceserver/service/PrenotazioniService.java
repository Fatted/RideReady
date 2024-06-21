package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import com.example.rrclientmodelresourceserver.model.UtenteEntity;
import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.repository.PrenotazioniRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import org.SwaggerCodeGenerator.model.Prenotazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.rrclientmodelresourceserver.converter.PrenotazioniConverter.convertToEntity;
import static com.example.rrclientmodelresourceserver.converter.PrenotazioniConverter.convertToSwaggerSchema;

@Service
public class PrenotazioniService {

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AutomobileRepository automobileRepository;

    private static final Logger logger = LoggerFactory.getLogger(PrenotazioniService.class);


    public Prenotazione prenotazioniClieentiAcquistoInserimentoPost(Prenotazione prenotazione) {

        AutomobileEntity automobileEntity=automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null); //cerco l'automobile con l'id passato
        if(automobileEntity==null){ //se l'automobile non è presente nel database
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }

        UtenteEntity utenteEntity=utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()); //cerco l'utente con il codice fiscale passato
        if(utenteEntity==null){ //se l'utente non è presente nel database
            UtenteEntity utente=new UtenteEntity();
            utente.setCodicefiscale(prenotazione.getIdUtente());
            utenteRepository.save(utente); //salvo l'utente
        }

        PrenotazioneEntity prenotazione_acquisto=convertToEntity(prenotazione);
        prenotazione_acquisto.setTipo("acquisto");
        prenotazione_acquisto.setStato("in attesa");
        prenotazione_acquisto.setIdUtente(utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()));
        prenotazione_acquisto.setIdAutomobile(automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null));
        prenotazioniRepository.save(prenotazione_acquisto); //salvo la prenotazione
        return prenotazione;
    }

    public Prenotazione prenotazioniClieentiNoleggioInserimentoPost(Prenotazione prenotazione) {

        AutomobileEntity automobileEntity=automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null); //cerco l'automobile con l'id passato
        if(automobileEntity==null){ //se l'automobile non è presente nel database
            logger.info("Automobile non presente nel database");
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }

        UtenteEntity utenteEntity=utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()); //cerco l'utente con il codice fiscale passato
        if(utenteEntity==null){ //se l'utente non è presente nel database
            UtenteEntity utente=new UtenteEntity();
            utente.setCodicefiscale(prenotazione.getIdUtente());
            utenteRepository.save(utente); //salvo l'utente
        }

        PrenotazioneEntity prenotazione_acquisto=convertToEntity(prenotazione);
        prenotazione_acquisto.setTipo("noleggio");
        prenotazione_acquisto.setStato("in attesa");
        prenotazione_acquisto.setIdUtente(utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()));
        prenotazione_acquisto.setIdAutomobile(automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null));
        prenotazioniRepository.save(prenotazione_acquisto); //salvo la prenotazione
        return prenotazione;
    }
    
    public List<Prenotazione> prenotazioniAmministratoriAcquistoGet(){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByTipo("acquisto");
        List<Prenotazione> prenotazioni_acquisto = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            prenotazioni_acquisto.add(convertToSwaggerSchema(prenotazione));
        }
        return prenotazioni_acquisto;
    }

    public List<Prenotazione> prenotazioniAmministratoriNoleggioGet(){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByTipo("noleggio");
        List<Prenotazione> prenotazioni_noleggio = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            prenotazioni_noleggio.add(convertToSwaggerSchema(prenotazione));
        }
        return prenotazioni_noleggio;
    }
}
