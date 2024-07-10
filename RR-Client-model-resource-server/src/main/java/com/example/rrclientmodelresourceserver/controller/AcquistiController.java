package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.AcquistiService;
import org.SwaggerCodeGenerator.api.AcquistiApi;
import org.SwaggerCodeGenerator.model.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AcquistiController implements AcquistiApi {

    @Autowired
    private AcquistiService acquistiService;

    private static final Logger logger = LoggerFactory.getLogger(AcquistiController.class);

    @Override // override del metodo acquistiClientiGet con endpoint /acquisti/clienti
    public ResponseEntity<List<Ordine>> acquistiClientiGet(String principal) {
        logger.info("AcquistiClientiGet-controller");
        return ResponseEntity.ok(acquistiService.acquistiClientiGet(principal));
    }
}
