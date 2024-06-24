package com.example.rrclientmodelresourceserver.converter;

import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import org.SwaggerCodeGenerator.model.Prenotazione;
import java.math.BigDecimal;


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
