package com.example.rrclientmodelresourceserver.DTO;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;
import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import com.example.rrclientmodelresourceserver.validation.Targa;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;
import java.util.Set;

@Validated
public class AutomobileDTO {

    private Integer id;

    @NotBlank(message = "Il campo marca non può essere vuoto")
    private String marca;

    @NotBlank(message = "Il campo modello non può essere vuoto")
    private String modello;

    private Double prezzoAcquisto;
    private Double prezzoNoleggioGiornaliero;
    private Boolean disponibile;

    @Min(value = 1, message = "Il campo quantità deve essere maggiore di 0")
    private Integer quantita;
    private Integer cavalli;
    private Double cilindrata;
    private Integer postiASedere;
    private String carburante;

    @Targa
    private String targa;

    @NotBlank(message = "Il campo tipo di destinazione non può essere vuoto")
    @Pattern(regexp = "^(noleggio|acquisto)$", message = "Il campo tipo di destinazione può essere solo 'noleggio' o 'acquisto'")
    private String tipoDiDestinazione;

    private Set<OrdineEntity> ordines;
    private Set<PrenotazioneEntity> prenotaziones;

    public AutomobileDTO(Integer id, String marca, String modello, BigDecimal bigDecimal, BigDecimal bigDecimal1, Boolean disponibile, Integer quantita, Integer cavalli, Double cilindrata, Integer postiASedere, String carburante, String targa, String tipoDiDestinazione, Set<OrdineEntity> ordines, Set<PrenotazioneEntity> prenotaziones) {
    this.id = id;
    this.marca = marca;
    this.modello = modello;
    this.prezzoAcquisto = bigDecimal.doubleValue();
    this.prezzoNoleggioGiornaliero = bigDecimal1.doubleValue();
    this.disponibile = disponibile;
    this.quantita = quantita;
    this.cavalli = cavalli;
    this.cilindrata = cilindrata;
    this.postiASedere = postiASedere;
    this.carburante = carburante;
    this.targa = targa;
    this.tipoDiDestinazione = tipoDiDestinazione;
    this.ordines = ordines;
    this.prenotaziones = prenotaziones;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<PrenotazioneEntity> getPrenotaziones() {
        return prenotaziones;
    }

    public void setPrenotaziones(Set<PrenotazioneEntity> prenotaziones) {
        this.prenotaziones = prenotaziones;
    }

    public Set<OrdineEntity> getOrdines() {
        return ordines;
    }

    public void setOrdines(Set<OrdineEntity> ordines) {
        this.ordines = ordines;
    }

    public String getTipoDiDestinazione() {
        return tipoDiDestinazione;
    }

    public void setTipoDiDestinazione(String tipoDiDestinazione) {
        this.tipoDiDestinazione = tipoDiDestinazione;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCarburante() {
        return carburante;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public Integer getPostiASedere() {
        return postiASedere;
    }

    public void setPostiASedere(Integer postiASedere) {
        this.postiASedere = postiASedere;
    }

    public Double getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Double cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Integer getCavalli() {
        return cavalli;
    }

    public void setCavalli(Integer cavalli) {
        this.cavalli = cavalli;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Boolean getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(Boolean disponibile) {
        this.disponibile = disponibile;
    }

    public Double getPrezzoNoleggioGiornaliero() {
        return prezzoNoleggioGiornaliero;
    }

    public void setPrezzoNoleggioGiornaliero(Double prezzoNoleggioGiornaliero) {
        this.prezzoNoleggioGiornaliero = prezzoNoleggioGiornaliero;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

}