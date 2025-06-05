package com.fiap.mecatronia.api_enchentes.controller;

import com.fiap.mecatronia.api_enchentes.dto.SensorDTO;
import com.fiap.mecatronia.api_enchentes.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @PostMapping
    public ResponseEntity<SensorDTO> cadastrar(@RequestBody SensorDTO dto) {
        SensorDTO salvo = sensorService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    // Outros métodos, como GET, se necessário
}
