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
        return ResponseEntity.ok(prenotazioniService.prenotazioniAmministratoriNoleggioGet());
    }

    @Override
    public ResponseEntity<List<Prenotazione>> prenotazioniClientiAcquistoGet(String principal) {
        return ResponseEntity.ok(prenotazioniService.prenotazioniClientiAcquistoGet(principal));
    }

    @Override
    public ResponseEntity<List<Prenotazione>> prenotazioniClientiNoleggioGet(String principal) {
        return ResponseEntity.ok(prenotazioniService.prenotazioniClientiNoleggioGet(principal));
    }

}
