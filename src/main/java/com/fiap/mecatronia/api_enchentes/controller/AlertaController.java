package com.fiap.mecatronia.api_enchentes.controller;

import com.fiap.mecatronia.api_enchentes.dto.AlertaDTO;
import com.fiap.mecatronia.api_enchentes.service.AlertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public List<AlertaDTO> listar() {
        return alertaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<AlertaDTO> cadastrar(@RequestBody AlertaDTO dto) {
        AlertaDTO salvo = alertaService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
