package com.fiap.mecatronia.api_enchentes.controller;

import com.fiap.mecatronia.api_enchentes.dto.SensorDTO;
import com.fiap.mecatronia.api_enchentes.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensores")
@CrossOrigin(origins = "*")  // Adicione esta linha para permitir acesso do frontend
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping  // Adicione este método para listar os sensores
    public List<SensorDTO> listar() {
        return sensorService.listar();
    }

    @PostMapping
    public ResponseEntity<SensorDTO> cadastrar(@RequestBody SensorDTO dto) {
        SensorDTO salvo = sensorService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}