package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.DTO.AutomobileDTO;
import com.example.rrclientmodelresourceserver.service.AutomobileService;
import org.SwaggerCodeGenerator.api.VeicoliApi;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;

@RestController
public class VeicoliController implements VeicoliApi{


    @Autowired
    private AutomobileService automobileService;

    @Override
    public ResponseEntity<Automobile> veicoliIdGet(BigDecimal id) {
        AutomobileDTO automobileDTO = automobileService.veicoliIdGet(id.intValue());
        Automobile automobile = automobileService.convertToSwaggerSchema(automobileDTO);
        return ResponseEntity.ok(automobile);
    }

    @Override
    public ResponseEntity<Void> veicoliAmministratoriInserimentoPost(Automobile automobile) {
        automobileService.veicoliAmministratoriInserimentoPost(automobile);
        return ResponseEntity.ok().build();
    }
}
