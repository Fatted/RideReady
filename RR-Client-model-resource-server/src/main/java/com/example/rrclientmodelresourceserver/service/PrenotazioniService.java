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

import java.math.BigDecimal;
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
        if(automobileEntity!=null){ //se l'automobile non è presente nel database
            if(!automobileEntity.getDisponibile() || !automobileEntity.getTipoDiDestinazione().equals("acquisto")){
                throw new ResourceNotFoundException("Automobile non disponibile per l'acquisto"); //lancio un'eccezione catturata dal global exception handler
            }
        }else
        {
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }

        UtenteEntity utenteEntity=utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()); //cerco l'utente con il codice fiscale passato
        if(utenteEntity==null){ //se l'utente non è presente nel database
            UtenteEntity utente=new UtenteEntity();
            utente.setCodicefiscale(prenotazione.getIdUtente());
            utenteRepository.save(utente); //salvo l'utente
        }

        PrenotazioneEntity prenotazione_noleggio_check=prenotazioniRepository.checkPrenotazioneEsistente(automobileEntity, prenotazione.getDataPrenotazione(), utenteEntity, "acquisto");
        if(prenotazione_noleggio_check!=null){
            throw new ResourceNotFoundException("Prenotazione già presente"); //lancio un'eccezione catturata dal global exception handler
        }

        PrenotazioneEntity prenotazione_acquisto=convertToEntity(prenotazione);
        prenotazione_acquisto.setTipo("acquisto");
        prenotazione_acquisto.setStato("in attesa");
        prenotazione_acquisto.setIdUtente(utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()));
        prenotazione_acquisto.setIdAutomobile(automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null));
        prenotazioniRepository.save(prenotazione_acquisto); //salvo la prenotazione

        return convertToSwaggerSchema(prenotazione_acquisto);
    }

    public Prenotazione prenotazioniClieentiNoleggioInserimentoPost(Prenotazione prenotazione) {

        AutomobileEntity automobileEntity=automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null); //cerco l'automobile con l'id passato
        if(automobileEntity!=null){
            if(!automobileEntity.getDisponibile() || !automobileEntity.getTipoDiDestinazione().equals("noleggio")){
                throw new ResourceNotFoundException("Automobile non disponibile per il noleggio"); //lancio un'eccezione catturata dal global exception handler
            }
        }else
        {
            throw new ResourceNotFoundException("Automobile non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }

        UtenteEntity utenteEntity=utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()); //cerco l'utente con il codice fiscale passato
        if(utenteEntity==null){ //se l'utente non è presente nel database
            UtenteEntity utente=new UtenteEntity();
            utente.setCodicefiscale(prenotazione.getIdUtente());
            utenteRepository.save(utente); //salvo l'utente
        }

        PrenotazioneEntity prenotazione_noleggio_check=prenotazioniRepository.checkPrenotazioneEsistente(automobileEntity, prenotazione.getDataPrenotazione(), utenteEntity, "noleggio");
        if(prenotazione_noleggio_check!=null){
            throw new ResourceNotFoundException("Prenotazione già presente"); //lancio un'eccezione catturata dal global exception handler
        }


        PrenotazioneEntity prenotazione_noleggio=convertToEntity(prenotazione);
        prenotazione_noleggio.setTipo("noleggio");
        prenotazione_noleggio.setStato("in attesa");
        prenotazione_noleggio.setIdUtente(utenteRepository.findByCodicefiscale(prenotazione.getIdUtente()));
        prenotazione_noleggio.setIdAutomobile(automobileRepository.findById(prenotazione.getIdAutomobile().intValue()).orElse(null));
        prenotazioniRepository.save(prenotazione_noleggio); //salvo la prenotazione
        return convertToSwaggerSchema(prenotazione_noleggio);
    }
    
    public List<Prenotazione> prenotazioniAmministratoriAcquistoGet(){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByTipoStatoInAttesa("acquisto");
        List<Prenotazione> prenotazioni_acquisto = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            prenotazioni_acquisto.add(convertToSwaggerSchema(prenotazione));
        }
        return prenotazioni_acquisto;
    }

    public List<Prenotazione> prenotazioniAmministratoriNoleggioGet(){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByTipoStatoInAttesa("noleggio");
        List<Prenotazione> prenotazioni_noleggio = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            prenotazioni_noleggio.add(convertToSwaggerSchema(prenotazione));
        }
        return prenotazioni_noleggio;
    }
    
    public List<Prenotazione> prenotazioniClientiAcquistoGet(String principal){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByIdUtente(utenteRepository.findByCodicefiscale(principal));
        List<Prenotazione> prenotazioni_acquisto = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            if(prenotazione.getTipo().equals("acquisto")){ //se la prenotazione è di tipo acquisto
                prenotazioni_acquisto.add(convertToSwaggerSchema(prenotazione));
            }
        }
        return prenotazioni_acquisto;
    }

    public List<Prenotazione> prenotazioniClientiNoleggioGet(String principal){
        List<PrenotazioneEntity> prenotazioni=prenotazioniRepository.findByIdUtente(utenteRepository.findByCodicefiscale(principal));
        List<Prenotazione> prenotazioni_noleggio = new ArrayList<>();
        for(PrenotazioneEntity prenotazione:prenotazioni){
            if(prenotazione.getTipo().equals("noleggio")){ //se la prenotazione è di tipo noleggio
                prenotazioni_noleggio.add(convertToSwaggerSchema(prenotazione));
            }
        }
        return prenotazioni_noleggio;
    }

    public Prenotazione prenotazioniAmministratoriAcquistoModificaIdPut(BigDecimal id, Prenotazione prenotazione) {
        PrenotazioneEntity prenotazioneEntity = prenotazioniRepository.findById(id.longValue()).orElse(null);
        if (prenotazioneEntity == null) {
            throw new ResourceNotFoundException("Prenotazione non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }
        if (!prenotazioneEntity.getTipo().equals("acquisto")) {
            throw new ResourceNotFoundException("Prenotazione non di tipo acquisto"); //lancio un'eccezione catturata dal global exception handler
        }
        if (!prenotazioneEntity.getStato().equals("in attesa")) {
            throw new ResourceNotFoundException("Prenotazione non in attesa"); //lancio un'eccezione catturata dal global exception handler
        }
        prenotazioneEntity.setStato(prenotazione.getStato());
        prenotazioniRepository.save(prenotazioneEntity); //salvo la prenotazione
        return convertToSwaggerSchema(prenotazioneEntity);
    }

    public Prenotazione prenotazioniAmministratoriNoleggioModificaIdPut(BigDecimal id, Prenotazione prenotazione) {
        PrenotazioneEntity prenotazioneEntity = prenotazioniRepository.findById(id.longValue()).orElse(null);
        if (prenotazioneEntity == null) {
            throw new ResourceNotFoundException("Prenotazione non trovata o non presente nel database"); //lancio un'eccezione catturata dal global exception handler
        }
        if (!prenotazioneEntity.getTipo().equals("noleggio")) {
            throw new ResourceNotFoundException("Prenotazione non di tipo noleggio"); //lancio un'eccezione catturata dal global exception handler
        }
        if (!prenotazioneEntity.getStato().equals("in attesa")) {
            throw new ResourceNotFoundException("Prenotazione non in attesa"); //lancio un'eccezione catturata dal global exception handler
        }
        prenotazioneEntity.setStato(prenotazione.getStato());
        prenotazioniRepository.save(prenotazioneEntity); //salvo la prenotazione
        return convertToSwaggerSchema(prenotazioneEntity);
    }

}
