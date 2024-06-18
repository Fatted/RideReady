package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.AutomobileService;
import org.SwaggerCodeGenerator.api.VeicoliApi;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;

@RestController
public class VeicoliController implements VeicoliApi {


    @Autowired
    private AutomobileService automobileService;

    @Override
    public ResponseEntity<Automobile> veicoliIdGet(BigDecimal id) {
        return ResponseEntity.ok(automobileService.veicoliIdGet(id.intValue()));
    }

    @Override
    public ResponseEntity<Automobile> veicoliAmministratoriInserimentoPost(Automobile automobile) {
        return ResponseEntity.ok(automobileService.veicoliAmministratoriInserimentoPost(automobile));
    }
}
