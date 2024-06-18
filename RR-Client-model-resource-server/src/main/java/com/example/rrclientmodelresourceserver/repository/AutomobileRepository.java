package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer>{

    @Transactional
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='noleggio' ")
    List<AutomobileEntity> veicoliNoleggioGet();

    @Transactional
    @Query("SELECT a FROM AutomobileEntity a WHERE a.tipoDiDestinazione ='acquisto' ")
    List<AutomobileEntity> veicoliAcquistoGet();
}
