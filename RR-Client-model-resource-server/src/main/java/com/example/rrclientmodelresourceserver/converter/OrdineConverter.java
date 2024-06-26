package com.example.rrclientmodelresourceserver.converter;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;
import com.example.rrclientmodelresourceserver.repository.AutomobileRepository;
import com.example.rrclientmodelresourceserver.repository.PrenotazioniRepository;
import com.example.rrclientmodelresourceserver.repository.UtenteRepository;
import org.SwaggerCodeGenerator.model.Ordine;

import java.math.BigDecimal;

public class OrdineConverter {

    public static Ordine convertToSwaggerSchemaOrdine(OrdineEntity ordineEntity) {
        Ordine ordine = new Ordine();
        ordine.setId(ordineEntity.getId());
        ordine.setIdPrenotazione(ordineEntity.getIdPrenotazione().getId());
        ordine.setIdUtente(ordineEntity.getIdUtente().getCodicefiscale());
        ordine.setIdAutomobile(ordineEntity.getIdAutomobile().getId());
        ordine.setTipo(ordineEntity.getTipo());
        ordine.setDataAcquistoAutomobile(ordineEntity.getDataAcquistoAutomobile());
        ordine.setDataNoleggioInizio(ordineEntity.getDataNoleggioInizio());
        ordine.setDataNoleggioFine(ordineEntity.getDataNoleggioFine());
        ordine.setPrezzoAcquistoAutoOrdine(BigDecimal.valueOf(ordineEntity.getPrezzoAcquistoAutoOrdine()));
        ordine.setPrezzoNoleggioGiornalieroOrdine(BigDecimal.valueOf(ordineEntity.getPrezzoNoleggioGiornalieroOrdine()));
        return ordine;
    }

    public static OrdineEntity convertToEntityOrdine(Ordine ordine) {
        OrdineEntity ordineEntity = new OrdineEntity();
        ordineEntity.setId(ordine.getId());
        ordineEntity.setTipo(ordine.getTipo());
        ordineEntity.setDataAcquistoAutomobile(ordine.getDataAcquistoAutomobile());
        ordineEntity.setDataNoleggioInizio(ordine.getDataNoleggioInizio());
        ordineEntity.setDataNoleggioFine(ordine.getDataNoleggioFine());
        ordineEntity.setPrezzoAcquistoAutoOrdine(ordine.getPrezzoAcquistoAutoOrdine().doubleValue());
        ordineEntity.setPrezzoNoleggioGiornalieroOrdine(ordine.getPrezzoNoleggioGiornalieroOrdine().doubleValue());
        return ordineEntity;
    }
}
