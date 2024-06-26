package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.converter.OrdineConverter;
import com.example.rrclientmodelresourceserver.model.OrdineEntity;
import com.example.rrclientmodelresourceserver.repository.OrdineRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import org.SwaggerCodeGenerator.model.Ordine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AcquistiService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    private static final Logger logger = LoggerFactory.getLogger(AcquistiService.class);

    public List<Ordine> acquistiClientiGet(String principal) {
        logger.info("acquistiClientiGet-service");

        List<OrdineEntity> ordineEntities; //creo una lista di ordini

        if(utenteRepository.findByCodicefiscale(principal) == null) { //cerco l'utente e vedo se esiste, se non esiste
            throw new ResourceNotFoundException("Utente non trovato"); //lancio un'eccezione
        }else{
            ordineEntities = ordineRepository.findByIdUtenteAndAcquisto(utenteRepository.findByCodicefiscale(principal)); //cerco tutti gli ordini di acquisto di un utente in base al suo id
        }
        return ordineEntities.stream().map(OrdineConverter::convertToSwaggerSchemaOrdine).collect(Collectors.toList()); //ritorno la lista di ordini convertita in swagger schema
    }


}
