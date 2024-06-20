package com.example.rrclientmodelresourceserver.converter;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import org.SwaggerCodeGenerator.model.Automobile;

import java.math.BigDecimal;

public class AutomobileConverter {

    //converte un'automobileEntity in un'automobile
    public static Automobile convertToSwaggerSchema(AutomobileEntity automobileEntity) {
        Automobile automobile = new Automobile();
        automobile.setId(BigDecimal.valueOf(automobileEntity.getId()));
        automobile.setMarca(automobileEntity.getMarca());
        automobile.setModello(automobileEntity.getModello());
        automobile.setPrezzoAcquisto(BigDecimal.valueOf(automobileEntity.getPrezzoAcquisto()));
        automobile.setPrezzoNoleggioGiornaliero(BigDecimal.valueOf(automobileEntity.getPrezzoNoleggioGiornaliero()));
        automobile.setDisponibile(automobileEntity.getDisponibile());
        automobile.setQuantita(BigDecimal.valueOf(automobileEntity.getQuantita()));
        automobile.setCavalli(BigDecimal.valueOf(automobileEntity.getCavalli()));
        automobile.setCilindrata(BigDecimal.valueOf(automobileEntity.getCilindrata()));
        automobile.setPostiASedere(BigDecimal.valueOf(automobileEntity.getPostiASedere()));
        automobile.setCarburante(automobileEntity.getCarburante());
        automobile.setTarga(automobileEntity.getTarga());
        automobile.setTipoDiDestinazione(automobileEntity.getTipoDiDestinazione());
        return automobile;
    }

    //converte un'automobile in un'automobileEntity
    public static AutomobileEntity convertToEntity(Automobile automobile) {
        AutomobileEntity automobileEntity = new AutomobileEntity();
        automobileEntity.setId(automobile.getId().intValue());
        automobileEntity.setMarca(automobile.getMarca());
        automobileEntity.setModello(automobile.getModello());
        automobileEntity.setPrezzoAcquisto(automobile.getPrezzoAcquisto().doubleValue());
        automobileEntity.setPrezzoNoleggioGiornaliero(automobile.getPrezzoNoleggioGiornaliero().doubleValue());
        automobileEntity.setDisponibile(automobile.getDisponibile());
        automobileEntity.setQuantita(automobile.getQuantita().intValue());
        automobileEntity.setCavalli(automobile.getCavalli().intValue());
        automobileEntity.setCilindrata(automobile.getCilindrata().doubleValue());
        automobileEntity.setPostiASedere(automobile.getPostiASedere().intValue());
        automobileEntity.setCarburante(automobile.getCarburante());
        automobileEntity.setTarga(automobile.getTarga());
        automobileEntity.setTipoDiDestinazione(automobile.getTipoDiDestinazione());
        return automobileEntity;
    }
}
