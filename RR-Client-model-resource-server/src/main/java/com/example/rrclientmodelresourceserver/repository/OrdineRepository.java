package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;
import com.example.rrclientmodelresourceserver.model.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdineRepository extends JpaRepository<OrdineEntity, Long> {






    //cerco tutti gli ordini di acquisto di un utente in base al suo id
    @Query("SELECT o FROM OrdineEntity o WHERE o.idUtente = ?1 AND o.tipo = 'acquisto' ")
    List<OrdineEntity> findByIdUtenteAndAcquisto(UtenteEntity idUtente);
}
