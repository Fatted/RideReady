package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer>{

    @Transactional
    //query per ottenere automobili  se disponibili e destinate al noleggio
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='noleggio' and a.disponibile = true")
    List<AutomobileEntity> veicoliNoleggioGet();

    @Transactional
    //query per ottenere automobili  se disponibili e destinate all'acquisto
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='acquisto' and a.disponibile = true")
    List<AutomobileEntity> veicoliAcquistoGet();

    @Transactional
    //query per ottenere automobili  se disponibili e destinate al noleggio
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='noleggio'")
    List<AutomobileEntity> veicoliNoleggioGetAmministartori();

    @Transactional
    //query per ottenere automobili  se disponibili e destinate all'acquisto
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='acquisto'")
    List<AutomobileEntity> veicoliAcquistoGetAmministratori();
}
