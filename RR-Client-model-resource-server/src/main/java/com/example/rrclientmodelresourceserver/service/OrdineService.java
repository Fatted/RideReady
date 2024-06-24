package com.example.rrclientmodelresourceserver.service;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;

import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.repository.OrdineRepository;
import com.example.rrclientmodelresourceserver.repository.PrenotazioniRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import com.example.rrclientmodelresourceserver.validation.ResourceNotFoundException;
import org.SwaggerCodeGenerator.model.Ordine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.rrclientmodelresourceserver.converter.OrdineConverter.convertToEntityOrdine;
import static com.example.rrclientmodelresourceserver.converter.OrdineConverter.convertToSwaggerSchemaOrdine;

@Service
public class OrdineService {

    @Autowired
    private OrdineRepository ordineRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AutomobileRepository automobileRepository;

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    public Ordine ordineAmministratoriAcquistoConfermaPost(Ordine ordine) {

        if(utenteRepository.findByCodicefiscale(ordine.getIdUtente()) == null) {
            throw new ResourceNotFoundException("Utente non presente nel database");
        }

        if(automobileRepository.findById(ordine.getIdAutomobile()).isEmpty()) {
            throw new ResourceNotFoundException("Automobile non presente nel database");
        }

        if(prenotazioniRepository.findById((long) ordine.getIdPrenotazione().intValue()).isEmpty()) {
            throw new ResourceNotFoundException("Prenotazione non presente nel database");
        }

        OrdineEntity ordineEntity = convertToEntityOrdine(ordine);
        ordineEntity.setIdAutomobile(automobileRepository.findById(ordine.getIdAutomobile()).get());
        ordineEntity.setIdUtente(utenteRepository.findByCodicefiscale(ordine.getIdUtente()));
        ordineEntity.setIdPrenotazione(prenotazioniRepository.findById(ordine.getIdPrenotazione().longValue()).get());
        ordineEntity.setTipo("acquisto");
        ordineRepository.save(ordineEntity);

        automobileRepository.findById(ordine.getIdAutomobile()).get().setQuantita(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() - 1);
        if(automobileRepository.findById(ordine.getIdAutomobile()).get().getQuantita() == 0) {
            automobileRepository.findById(ordine.getIdAutomobile()).get().setDisponibile(false);
        }
        automobileRepository.save(automobileRepository.findById(ordine.getIdAutomobile()).get());
        return convertToSwaggerSchemaOrdine(ordineEntity);
    }
}
