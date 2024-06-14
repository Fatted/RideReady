package com.example.rrclientmodelresourceserver.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "automobile")
public class AutomobileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "marca", nullable = false)
    private String marca;

    @Column(name = "modello", nullable = false)
    private String modello;

    @Column(name = "prezzo_acquisto", nullable = false)
    private Double prezzoAcquisto;

    @Column(name = "prezzo_noleggio_giornaliero", nullable = false)
    private Double prezzoNoleggioGiornaliero;

    @Column(name = "disponibile", nullable = false)
    private Boolean disponibile = false;

    @Column(name = "quantita", nullable = false)
    private Integer quantita;

    @Column(name = "cavalli", nullable = false)
    private Integer cavalli;

    @Column(name = "cilindrata", nullable = false)
    private Double cilindrata;

    @Column(name = "posti_a_sedere", nullable = false)
    private Integer postiASedere;

    @Column(name = "carburante", nullable = false)
    private String carburante;

    @Column(name = "targa", nullable = false)
    private String targa;

    @Column(name = "tipo_di_destinazione", nullable = false)
    private String tipoDiDestinazione;

    @OneToMany(mappedBy = "idAutomobile")
    private Set<OrdineEntity> ordines = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idAutomobile")
    private Set<PrenotazioneEntity> prenotaziones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(Double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public Double getPrezzoNoleggioGiornaliero() {
        return prezzoNoleggioGiornaliero;
    }

    public void setPrezzoNoleggioGiornaliero(Double prezzoNoleggioGiornaliero) {
        this.prezzoNoleggioGiornaliero = prezzoNoleggioGiornaliero;
    }

    public Boolean getDisponibile() {
        return disponibile;
    }

    public void setDisponibile(Boolean disponibile) {
        this.disponibile = disponibile;
    }

    public Integer getQuantita() {
        return quantita;
    }

    public void setQuantita(Integer quantita) {
        this.quantita = quantita;
    }

    public Integer getCavalli() {
        return cavalli;
    }

    public void setCavalli(Integer cavalli) {
        this.cavalli = cavalli;
    }

    public Double getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Double cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Integer getPostiASedere() {
        return postiASedere;
    }

    public void setPostiASedere(Integer postiASedere) {
        this.postiASedere = postiASedere;
    }

    public String getCarburante() {
        return carburante;
    }

    public void setCarburante(String carburante) {
        this.carburante = carburante;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getTipoDiDestinazione() {
        return tipoDiDestinazione;
    }

    public void setTipoDiDestinazione(String tipoDiDestinazione) {
        this.tipoDiDestinazione = tipoDiDestinazione;
    }

    public Set<OrdineEntity> getOrdines() {
        return ordines;
    }

    public void setOrdines(Set<OrdineEntity> ordines) {
        this.ordines = ordines;
    }

    public Set<PrenotazioneEntity> getPrenotaziones() {
        return prenotaziones;
    }

    public void setPrenotaziones(Set<PrenotazioneEntity> prenotaziones) {
        this.prenotaziones = prenotaziones;
    }

}