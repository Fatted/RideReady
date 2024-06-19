package com.example.rrclientmodelresourceserver.controller;

import com.example.rrclientmodelresourceserver.service.VeicoliService;
import org.SwaggerCodeGenerator.api.VeicoliApi;
import org.SwaggerCodeGenerator.model.Automobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class VeicoliController implements VeicoliApi {

    private static final Logger logger = LoggerFactory.getLogger(VeicoliController.class);

    @Autowired
    private VeicoliService veicoliService;

    @Override
    public ResponseEntity<Automobile> veicoliIdGet(BigDecimal id) {
        logger.info("veicoliIdGet-controller");
        return ResponseEntity.ok(veicoliService.veicoliIdGet(id.intValue()));
    }

    @Override
    public ResponseEntity<Automobile> veicoliAmministratoriInserimentoPost(Automobile automobile) {
        logger.info("veicoliAmministratoriInserimentoPost-controller");
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriInserimentoPost(automobile));
    }

    @Override
    public ResponseEntity<Automobile> veicoliAmministratoriModificaIdPut(BigDecimal id, Automobile automobile) {
        logger.info("veicoliAmministratoriModificaIdPut-controller");
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriModificaIdPut(id.intValue(), automobile));
    }


    @Override
    public ResponseEntity<String> veicoliAmministratoriEliminaIdDelete(BigDecimal id) {
        logger.info("veicoliAmministratoriEliminaIdDelete-controller");
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriEliminaIdDelete(id.intValue()));
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliAmministratoriNoleggioGet() {
        logger.info("veicoliAmministratoriNoleggioGet-controller");
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriNoleggioGet());
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliAmministratoriAcquistoGet() {
        logger.info("veicoliAmministratoriAcquistoGet-controller");
        return ResponseEntity.ok(veicoliService.veicoliAmministratoriAcquistoGet());
    }


    @Override
    public ResponseEntity<List<Automobile>> veicoliClientiAcquistoGet() {
        logger.info("veicoliClientiAcquistoGet-controller");
        return ResponseEntity.ok(veicoliService.veicoliClientiAcquistoGet());
    }

    @Override
    public ResponseEntity<List<Automobile>> veicoliClientiNoleggioGet() {
        logger.info("veicoliClientiNoleggioGet-controller");
        return ResponseEntity.ok(veicoliService.veicoliClientiNoleggioGet());
    }
}
