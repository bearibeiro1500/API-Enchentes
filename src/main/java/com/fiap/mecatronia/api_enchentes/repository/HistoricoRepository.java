package com.fiap.mecatronia.api_enchentes.repository;

import com.fiap.mecatronia.api_enchentes.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Long> {
}
