package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.NoleggioService;
import org.SwaggerCodeGenerator.api.NoleggioApi;
import org.SwaggerCodeGenerator.model.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoleggioController implements NoleggioApi {

    @Autowired
    private NoleggioService noleggioService;

    private static final Logger logger = LoggerFactory.getLogger(NoleggioController.class);

    @Override //override del metodo noleggioClientiGet in NoleggioApi con endpoint /noleggio/clienti
    public ResponseEntity<List<Ordine>> noleggioClientiGet(String principal) {
        logger.info("noleggioClientiGet-controller");
        return ResponseEntity.ok(noleggioService.noleggioClientiGet(principal));
    }
}
