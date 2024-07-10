package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.UtenteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtenteRepository extends JpaRepository<UtenteEntity, Long> {

    public UtenteEntity findByCodicefiscale(String codicefiscale);

}
