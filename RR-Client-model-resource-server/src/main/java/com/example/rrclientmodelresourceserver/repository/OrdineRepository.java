package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.OrdineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdineRepository extends JpaRepository<OrdineEntity, Long> {
}
