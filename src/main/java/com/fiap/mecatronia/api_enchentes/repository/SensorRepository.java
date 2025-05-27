package com.fiap.mecatronia.api_enchentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fiap.mecatronia.api_enchentes.model.Sensor;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
