package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface PrenotazioniRepository extends JpaRepository<PrenotazioneEntity, Long> {

    @Query("SELECT p FROM PrenotazioneEntity p WHERE p.tipo = ?1 AND p.stato = 'in attesa'")
    List<PrenotazioneEntity> findByTipo(String acquisto);
}
