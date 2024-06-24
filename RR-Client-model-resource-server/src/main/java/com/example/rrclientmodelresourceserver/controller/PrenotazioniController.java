package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.PrenotazioniService;
import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.SwaggerCodeGenerator.api.PrenotazioniApi;
import org.SwaggerCodeGenerator.model.Prenotazione;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class PrenotazioniController implements PrenotazioniApi {

    private static final Logger logger = LoggerFactory.getLogger(PrenotazioniController.class);

    @Autowired
    private PrenotazioniService prenotazioniService;


    @Override //override del metodo prenotazioniClientiAcquistoInserimentoPost in PrenotazioniApi con endpoint /prenotazioni/clienti/acquisto/inserimento
    public ResponseEntity<Prenotazione> prenotazioniClientiAcquistoInserimentoPost(Prenotazione prenotazione) {
        logger.info("PrenotazioniClientiAcquistoInserimentoPost-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniClieentiAcquistoInserimentoPost(prenotazione));
    }

    @Override //override del metodo prenotazioniClientiNoleggioInserimentoPost in PrenotazioniApi con endpoint /prenotazioni/clienti/noleggio/inserimento
    public ResponseEntity<Prenotazione> prenotazioniClientiNoleggioInserimentoPost(Prenotazione prenotazione) {
        logger.info("PrenotazioniClientiNoleggioInserimentoPost-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniClieentiNoleggioInserimentoPost(prenotazione));
    }

    @Override //override del metodo prenotazioniAmministratoriAcquistoGet in PrenotazioniApi con endpoint /prenotazioni/amministratori-acquisto
    public ResponseEntity<List<Prenotazione>> prenotazioniAmministratoriAcquistoGet() {
        logger.info("PrenotazioniAmministratoriAcquistoGet-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniAmministratoriAcquistoGet());
    }

    @Override //override del metodo prenotazioniAmministratoriNoleggioGet in PrenotazioniApi con endpoint /prenotazioni/amministratori-noleggio
    public ResponseEntity<List<Prenotazione>> prenotazioniAmministratoriNoleggioGet() {
        logger.info("PrenotazioniAmministratoriNoleggioGet-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniAmministratoriNoleggioGet());
    }

    @Override //override del metodo prenotazioniClientiAcquistoGet in PrenotazioniApi con endpoint /prenotazioni/clienti/acquisto
    public ResponseEntity<List<Prenotazione>> prenotazioniClientiAcquistoGet(String principal) {
        logger.info("PrenotazioniClientiAcquistoGet-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniClientiAcquistoGet(principal));
    }

    @Override //override del metodo prenotazioniClientiNoleggioGet in PrenotazioniApi con endpoint /prenotazioni/clienti/noleggio
    public ResponseEntity<List<Prenotazione>> prenotazioniClientiNoleggioGet(String principal) {
        logger.info("PrenotazioniClientiNoleggioGet-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniClientiNoleggioGet(principal));
    }

    @Override //override del metodo prenotazioniAmministratoriAcquistoModificaIdPut in PrenotazioniApi con endpoint /prenotazioni/amministratori/acquisto/modifica/{id}
    public ResponseEntity<Prenotazione> prenotazioniAmministratoriAcquistoModificaIdPut(BigDecimal id, Prenotazione prenotazione) {
        logger.info("PrenotazioniAmministratoriAcquistoModificaIdPut-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniAmministratoriAcquistoModificaIdPut(id, prenotazione));
    }

    @Override //override del metodo prenotazioniAmministratoriNoleggioModificaIdPut in PrenotazioniApi con endpoint /prenotazioni/amministratori/noleggio/modifica/{id}
    public ResponseEntity<Prenotazione> prenotazioniAmministratoriNoleggioModificaIdPut(BigDecimal id, Prenotazione prenotazione) {
        logger.info("PrenotazioniAmministratoriNoleggioModificaIdPut-controller");
        return ResponseEntity.ok(prenotazioniService.prenotazioniAmministratoriNoleggioModificaIdPut(id, prenotazione));
    }
}
