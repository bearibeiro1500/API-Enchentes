package com.fiap.mecatronia.api_enchentes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fiap.mecatronia.api_enchentes.model.Alerta;

@Repository
public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
