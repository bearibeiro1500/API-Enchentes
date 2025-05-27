package com.fiap.mecatronia.api_enchentes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

import com.fiap.mecatronia.api_enchentes.model.Sensor;
import com.fiap.mecatronia.api_enchentes.repository.SensorRepository;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> listarTodos() {
        return sensorRepository.findAll();
    }

    public Sensor salvar(Sensor sensor) {
        sensor.setDataLeitura(LocalDateTime.now());
        return sensorRepository.save(sensor);
    }
}
