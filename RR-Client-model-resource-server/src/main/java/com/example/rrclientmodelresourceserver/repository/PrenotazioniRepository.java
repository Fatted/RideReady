package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import com.example.rrclientmodelresourceserver.model.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


public interface PrenotazioniRepository extends JpaRepository<PrenotazioneEntity, Long> {

    @Query("SELECT p FROM PrenotazioneEntity p WHERE p.tipo = ?1 AND p.stato = 'in attesa'")
    List<PrenotazioneEntity> findByTipoStatoInAttesa(String acquisto);

    @Query("SELECT p FROM PrenotazioneEntity p WHERE p.idAutomobile = ?1 AND p.dataPrenotazione = ?2 AND p.idUtente = ?3 AND p.tipo = ?4")
    PrenotazioneEntity checkPrenotazioneEsistente(AutomobileEntity idAutomobile, LocalDate dataPrenotazione, UtenteEntity idUtente, String tipo);

    List<PrenotazioneEntity> findByIdUtente(UtenteEntity idUtente);
}
