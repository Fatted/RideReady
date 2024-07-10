package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.OrdineService;
import org.SwaggerCodeGenerator.api.OrdineApi;
import org.SwaggerCodeGenerator.model.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdineController implements OrdineApi {

    @Autowired
    private OrdineService ordineService;

    private static final Logger logger = LoggerFactory.getLogger(OrdineController.class);

    @Override //override del metodo ordineAmministratoriAcquistoConfermaPost con endpoint /ordine/amministratori-acquisto/conferma
    public ResponseEntity<Ordine> ordineAmministratoriAcquistoConfermaPost(Ordine ordine) {
        logger.info("ordineAmministratoriAcquistoConfermaPost");
        return ResponseEntity.ok(ordineService.ordineAmministratoriAcquistoConfermaPost(ordine));
    }

    @Override //override del metodo ordineAmministratoriNoleggioConfermaPost con endpoint /ordine/amministratori-noleggio/conferma
    public ResponseEntity<Ordine> ordineAmministratoriNoleggioConfermaPost(Ordine ordine) {
        logger.info("ordineAmministratoriNoleggioConfermaPost");
        return ResponseEntity.ok(ordineService.ordineAmministratoriNoleggioConfermaPost(ordine));
    }


}
