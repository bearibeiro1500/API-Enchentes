package com.fiap.mecatronia.api_enchentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.HistoricoAcao;
import com.fiap.mecatronia.api_enchentes.service.ControleService;

@RestController
@RequestMapping("/controle")
public class ControleController {

    @Autowired
    private ControleService controleService;

    @GetMapping("/historico")
    public List<HistoricoAcao> listarHistorico() {
        return controleService.listarTodos();
    }

    @PostMapping("/registrar")
    public ResponseEntity<HistoricoAcao> registrarAcao(@RequestBody HistoricoAcao acao) {
        HistoricoAcao registrada = controleService.registrarAcao(acao);
        return new ResponseEntity<>(registrada, HttpStatus.CREATED);
    }
}
