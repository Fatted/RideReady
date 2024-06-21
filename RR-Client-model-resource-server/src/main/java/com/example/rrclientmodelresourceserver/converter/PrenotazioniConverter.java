package com.example.rrclientmodelresourceserver.converter;

import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import org.SwaggerCodeGenerator.model.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.ZoneOffset;

public class PrenotazioniConverter {

    public static PrenotazioneEntity convertToEntity(Prenotazione prenotazione) {
        PrenotazioneEntity entity = new PrenotazioneEntity();
        entity.setId(prenotazione.getId().intValue());
        entity.setTipo(prenotazione.getTipo());
        entity.setDataPrenotazione(prenotazione.getDataPrenotazione());
        entity.setStato(prenotazione.getStato());
        return entity;
    }

    public static Prenotazione convertToSwaggerSchema(PrenotazioneEntity entity) {
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setId(BigDecimal.valueOf(entity.getId()));
        prenotazione.setIdAutomobile(BigDecimal.valueOf(entity.getIdAutomobile().getId()));
        prenotazione.setIdUtente(entity.getIdUtente().getCodicefiscale());
        prenotazione.setTipo(entity.getTipo());
        prenotazione.setDataPrenotazione(entity.getDataPrenotazione());
        prenotazione.setStato(entity.getStato());
        return prenotazione;
    }
}
