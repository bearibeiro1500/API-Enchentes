package com.fiap.mecatronia.api_enchentes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.HistoricoAcao;
import com.fiap.mecatronia.api_enchentes.repository.HistoricoRepository;

@Service
public class ControleService {

    @Autowired
    private HistoricoRepository historicoRepository;

    public List<HistoricoAcao> listarTodos() {
        return historicoRepository.findAll();
    }

    public HistoricoAcao registrarAcao(HistoricoAcao acao) {
        acao.setDataHora(LocalDateTime.now());
        return historicoRepository.save(acao);
    }
}
