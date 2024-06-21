package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.PrenotazioneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PrenotazioniRepository extends JpaRepository<PrenotazioneEntity, Long> {

    List<PrenotazioneEntity> findByTipo(String acquisto);
}
