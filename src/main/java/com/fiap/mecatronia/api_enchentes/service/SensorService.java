package com.fiap.mecatronia.api_enchentes.service;

import com.fiap.mecatronia.api_enchentes.dto.SensorDTO;
import com.fiap.mecatronia.api_enchentes.model.Sensor;
import com.fiap.mecatronia.api_enchentes.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repo;

    private Sensor fromDTO(SensorDTO dto) {
        Sensor sensor = new Sensor();
        sensor.setId(dto.getId());
        sensor.setNivelAgua(dto.getNivelAgua());
        sensor.setClima(dto.getClima());
        sensor.setDataLeitura(dto.getDataLeitura());
        return sensor;
    }

    private SensorDTO toDTO(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setId(sensor.getId());
        dto.setNivelAgua(sensor.getNivelAgua());
        dto.setClima(sensor.getClima());
        dto.setDataLeitura(sensor.getDataLeitura());
        return dto;
    }

    public SensorDTO salvar(SensorDTO dto) {
        Sensor sensor = fromDTO(dto);
        if (sensor.getDataLeitura() == null) {
            sensor.setDataLeitura(java.time.LocalDateTime.now());
        }
        Sensor salvo = repo.save(sensor);
        return toDTO(salvo);
    }

    public List<SensorDTO> listar() {
        List<Sensor> sensores = repo.findAll();
        return sensores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
