package com.example.rrclientmodelresourceserver.model;

import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "utente")
public class UtenteEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "codicefiscale", nullable = false, length = 16)
    private String codicefiscale;

    @OneToMany(mappedBy = "idUtente")
    private Set<OrdineEntity> ordines = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idUtente")
    private Set<PrenotazioneEntity> prenotaziones = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodicefiscale() {
        return codicefiscale;
    }

    public void setCodicefiscale(String codicefiscale) {
        this.codicefiscale = codicefiscale;
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