package com.example.rrclientmodelresourceserver.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "ordine")
public class OrdineEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private LocalDate dataAcquistoAutomobile;

    @Column(name = "data_noleggio_inizio")
    private LocalDate dataNoleggioInizio;

    @Column(name = "data_noleggio_fine")
    private LocalDate dataNoleggioFine;

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

    public LocalDate getDataAcquistoAutomobile() {
        return dataAcquistoAutomobile;
    }

    public void setDataAcquistoAutomobile(LocalDate dataAcquistoAutomobile) {
        this.dataAcquistoAutomobile = dataAcquistoAutomobile;
    }

    public LocalDate getDataNoleggioInizio() {
        return dataNoleggioInizio;
    }

    public void setDataNoleggioInizio(LocalDate dataNoleggioInizio) {
        this.dataNoleggioInizio = dataNoleggioInizio;
    }

    public LocalDate getDataNoleggioFine() {
        return dataNoleggioFine;
    }

    public void setDataNoleggioFine(LocalDate dataNoleggioFine) {
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