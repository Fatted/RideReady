package com.example.rrclientmodelresourceserver.repository;

import com.example.rrclientmodelresourceserver.model.AutomobileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutomobileRepository extends JpaRepository<AutomobileEntity, Integer>{
}
