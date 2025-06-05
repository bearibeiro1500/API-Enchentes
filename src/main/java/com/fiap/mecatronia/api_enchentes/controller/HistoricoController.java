package com.fiap.mecatronia.api_enchentes.controller;

import com.fiap.mecatronia.api_enchentes.dto.HistoricoDTO;
import com.fiap.mecatronia.api_enchentes.service.HistoricoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historico")
public class HistoricoController {

    @Autowired
    private HistoricoService historicoService;

    @GetMapping
    public List<HistoricoDTO> listar() {
        return historicoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<HistoricoDTO> registrar(@RequestBody HistoricoDTO dto) {
        HistoricoDTO salvo = historicoService.registrarAcao(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
