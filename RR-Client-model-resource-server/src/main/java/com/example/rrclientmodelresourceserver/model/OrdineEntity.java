package com.example.rrclientmodelresourceserver.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name = "ordine")
public class OrdineEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_prenotazione", nullable = false)
    private PrenotazioneEntity idPrenotazione;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_utente", nullable = false, referencedColumnName = "codicefiscale")
    private UtenteEntity idUtente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_automobile", nullable = false)
    private AutomobileEntity idAutomobile;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "data_acquisto_automobile")
    private Instant dataAcquistoAutomobile;

    @Column(name = "data_noleggio_inizio")
    private Instant dataNoleggioInizio;

    @Column(name = "data_noleggio_fine")
    private Instant dataNoleggioFine;

    @Column(name = "prezzo_acquisto_auto_ordine", nullable = false)
    private Double prezzoAcquistoAutoOrdine;

    @Column(name = "prezzo_noleggio_giornaliero_ordine", nullable = false)
    private Double prezzoNoleggioGiornalieroOrdine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PrenotazioneEntity getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(PrenotazioneEntity idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public UtenteEntity getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UtenteEntity idUtente) {
        this.idUtente = idUtente;
    }

    public AutomobileEntity getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(AutomobileEntity idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Instant getDataAcquistoAutomobile() {
        return dataAcquistoAutomobile;
    }

    public void setDataAcquistoAutomobile(Instant dataAcquistoAutomobile) {
        this.dataAcquistoAutomobile = dataAcquistoAutomobile;
    }

    public Instant getDataNoleggioInizio() {
        return dataNoleggioInizio;
    }

    public void setDataNoleggioInizio(Instant dataNoleggioInizio) {
        this.dataNoleggioInizio = dataNoleggioInizio;
    }

    public Instant getDataNoleggioFine() {
        return dataNoleggioFine;
    }

    public void setDataNoleggioFine(Instant dataNoleggioFine) {
        this.dataNoleggioFine = dataNoleggioFine;
    }

    public Double getPrezzoAcquistoAutoOrdine() {
        return prezzoAcquistoAutoOrdine;
    }

    public void setPrezzoAcquistoAutoOrdine(Double prezzoAcquistoAutoOrdine) {
        this.prezzoAcquistoAutoOrdine = prezzoAcquistoAutoOrdine;
    }

    public Double getPrezzoNoleggioGiornalieroOrdine() {
        return prezzoNoleggioGiornalieroOrdine;
    }

    public void setPrezzoNoleggioGiornalieroOrdine(Double prezzoNoleggioGiornalieroOrdine) {
        this.prezzoNoleggioGiornalieroOrdine = prezzoNoleggioGiornalieroOrdine;
    }

}