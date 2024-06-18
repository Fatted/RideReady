package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.VeicoliService;
import org.SwaggerCodeGenerator.api.VeicoliApi;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import java.math.BigDecimal;
import java.util.List;

@RestController
public class VeicoliController implements VeicoliApi {


    @Autowired
    private VeicoliService veicoliService;

    @Override
    public ResponseEntity<Automobile> veicoliIdGet(BigDecimal id) {
        return ResponseEntity.ok(veicoliService.veicoliIdGet(id.intValue()));
    }

    @Override
    public ResponseEntity<Automobile> veicoliAmministratoriInserimentoPost(Automobile automobile) {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriInserimentoPost(automobile));
    }

    @Override
    public ResponseEntity<Automobile> veicoliAmministratoriModificaIdPut(BigDecimal id, Automobile automobile) {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriModificaIdPut(id.intValue(), automobile));
    }


    @Override
    public ResponseEntity<String> veicoliAmministratoriEliminaIdDelete(BigDecimal id) {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriEliminaIdDelete(id.intValue()));
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliAmministratoriNoleggioGet() {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriNoleggioGet());
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliAmministratoriAcquistoGet() {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriAcquistoGet());
    }


    @Override
    public ResponseEntity<List<Automobile>> veicoliClientiAcquistoGet() {
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriAcquistoGet());
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliClientiNoleggioGet() {
        return VeicoliApi.super.veicoliClientiNoleggioGet();
    }
}
