package com.fiap.mecatronia.api_enchentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.Alerta;
import com.fiap.mecatronia.api_enchentes.service.AlertaService;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaService alertaService;

    @GetMapping
    public List<Alerta> listar() {
        return alertaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Alerta> cadastrar(@RequestBody Alerta alerta) {
        Alerta salvo = alertaService.salvar(alerta);
        return new ResponseEntity<>(salvo, HttpStatus.CREATED);
    }
}
