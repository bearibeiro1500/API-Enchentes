package com.fiap.mecatronia.api_enchentes.service;

import com.fiap.mecatronia.api_enchentes.dto.AlertaDTO;
import com.fiap.mecatronia.api_enchentes.model.Alerta;
import com.fiap.mecatronia.api_enchentes.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertaService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<AlertaDTO> listarTodos() {
        return alertaRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    public AlertaDTO salvar(AlertaDTO dto) {
        Alerta entidade = dtoToEntity(dto);
        entidade.setDataAlerta(LocalDateTime.now());
        entidade = alertaRepository.save(entidade);
        System.out.println("Alerta salvo com id: " + entidade.getId());
        return entityToDto(entidade);
    }

    private Alerta dtoToEntity(AlertaDTO dto) {
        Alerta entidade = new Alerta();
        entidade.setId(dto.getId());
        entidade.setMensagem(dto.getMensagem());
        entidade.setTipo(dto.getTipo());
        entidade.setDataAlerta(dto.getDataAlerta());
        return entidade;
    }

    private AlertaDTO entityToDto(Alerta entidade) {
        AlertaDTO dto = new AlertaDTO();
        dto.setId(entidade.getId());
        dto.setMensagem(entidade.getMensagem());
        dto.setTipo(entidade.getTipo());
        dto.setDataAlerta(entidade.getDataAlerta());
        return dto;
    }
}
