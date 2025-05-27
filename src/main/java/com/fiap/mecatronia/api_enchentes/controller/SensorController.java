package com.fiap.mecatronia.api_enchentes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.Sensor;
import com.fiap.mecatronia.api_enchentes.service.SensorService;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public List<Sensor> listar() {
        return sensorService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Sensor> cadastrar(@RequestBody Sensor sensor) {
        Sensor salvo = sensorService.salvar(sensor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}
