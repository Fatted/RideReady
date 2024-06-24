package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.OrdineService;
import org.SwaggerCodeGenerator.api.OrdineApi;
import org.SwaggerCodeGenerator.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrdineController implements OrdineApi {

    @Autowired
    private OrdineService ordineService;

    @Override
    public ResponseEntity<Ordine> ordineAmministratoriAcquistoConfermaPost(Ordine ordine) {
        return ResponseEntity.ok(ordineService.ordineAmministratoriAcquistoConfermaPost(ordine));
    }

    @Override
    public ResponseEntity<Ordine> ordineAmministratoriNoleggioConfermaPost(Ordine ordine) {
        return OrdineApi.super.ordineAmministratoriNoleggioConfermaPost(ordine);
    }
}
