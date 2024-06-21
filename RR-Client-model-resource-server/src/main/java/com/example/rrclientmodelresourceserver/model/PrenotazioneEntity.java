package com.example.rrclientmodelresourceserver.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "prenotazione")
public class PrenotazioneEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_automobile", nullable = false)
    private AutomobileEntity idAutomobile;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_utente", nullable = false, referencedColumnName = "codicefiscale")
    private UtenteEntity idUtente;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "data_prenotazione", nullable = false)
    private LocalDate dataPrenotazione;

    @Column(name = "stato", nullable = false)
    private String stato;

    @OneToMany(mappedBy = "idPrenotazione")
    private Set<OrdineEntity> ordines = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AutomobileEntity getIdAutomobile() {
        return idAutomobile;
    }

    public void setIdAutomobile(AutomobileEntity idAutomobile) {
        this.idAutomobile = idAutomobile;
    }

    public UtenteEntity getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(UtenteEntity idUtente) {
        this.idUtente = idUtente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Set<OrdineEntity> getOrdines() {
        return ordines;
    }

    public void setOrdines(Set<OrdineEntity> ordines) {
        this.ordines = ordines;
    }

}