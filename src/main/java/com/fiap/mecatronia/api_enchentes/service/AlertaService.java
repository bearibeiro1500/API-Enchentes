package com.fiap.mecatronia.api_enchentes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.Alerta;
import com.fiap.mecatronia.api_enchentes.repository.AlertaRepository;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> listarTodos() {
        return alertaRepository.findAll();
    }

    public Alerta salvar(Alerta alerta) {
        alerta.setDataAlerta(LocalDateTime.now());
        return alertaRepository.save(alerta);
    }
}
