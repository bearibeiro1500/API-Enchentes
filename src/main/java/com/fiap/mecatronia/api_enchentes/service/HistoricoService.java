package com.fiap.mecatronia.api_enchentes.service;

import com.fiap.mecatronia.api_enchentes.dto.HistoricoDTO;
import com.fiap.mecatronia.api_enchentes.model.Historico;
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
        Historico entidade = dtoToEntity(dto);
        entidade.setDataHora(LocalDateTime.now());
        entidade = historicoRepository.save(entidade);
        System.out.println("Histórico salvo com id: " + entidade.getId());
        return entityToDto(entidade);
    }

    private Historico dtoToEntity(HistoricoDTO dto) {
        Historico entidade = new Historico();
        entidade.setId(dto.getId());
        entidade.setAcao(dto.getAcao());
        entidade.setOrigem(dto.getOrigem());
        // DataHora será atualizada no salvar, então aqui pode ignorar dto.getDataHora()
        return entidade;
    }

    private HistoricoDTO entityToDto(Historico entidade) {
        HistoricoDTO dto = new HistoricoDTO();
        dto.setId(entidade.getId());
        dto.setAcao(entidade.getAcao());
        dto.setOrigem(entidade.getOrigem());
        dto.setDataHora(entidade.getDataHora());
        return dto;
    }
}
