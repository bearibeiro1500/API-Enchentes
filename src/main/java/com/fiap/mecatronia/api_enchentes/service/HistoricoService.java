package com.fiap.mecatronia.api_enchentes.service;

import com.fiap.mecatronia.api_enchentes.dto.HistoricoDTO;
import com.fiap.mecatronia.api_enchentes.model.HistoricoAcao;
import com.fiap.mecatronia.api_enchentes.repository.HistoricoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoricoService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<HistoricoDTO> listarTodos() {
        return historicoRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .toList();
    }

    public HistoricoDTO registrarAcao(HistoricoDTO dto) {
        HistoricoAcao entidade = dtoToEntity(dto);
        entidade.setDataHora(LocalDateTime.now());
        entidade = historicoRepository.save(entidade);
        return entityToDto(entidade);
    }

    private HistoricoAcao dtoToEntity(HistoricoDTO dto) {
        HistoricoAcao entidade = new HistoricoAcao();
        entidade.setId(dto.getId());
        entidade.setAcao(dto.getAcao());
        entidade.setOrigem(dto.getOrigem());
        entidade.setDataHora(dto.getDataHora());
        return entidade;
    }

    private HistoricoDTO entityToDto(HistoricoAcao entidade) {
        HistoricoDTO dto = new HistoricoDTO();
        dto.setId(entidade.getId());
        dto.setAcao(entidade.getAcao());
        dto.setOrigem(entidade.getOrigem());
        dto.setDataHora(entidade.getDataHora());
        return dto;
    }
}
