package com.fiap.mecatronia.api_enchentes.service;

import com.fiap.mecatronia.api_enchentes.dto.SensorDTO;
import com.fiap.mecatronia.api_enchentes.model.Sensor;
import com.fiap.mecatronia.api_enchentes.model.Alerta;
import com.fiap.mecatronia.api_enchentes.model.Historico;
import com.fiap.mecatronia.api_enchentes.repository.SensorRepository;
import com.fiap.mecatronia.api_enchentes.repository.AlertaRepository;
import com.fiap.mecatronia.api_enchentes.repository.HistoricoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorService {

    @Autowired
    private SensorRepository repo;

    @Autowired
    private AlertaRepository alertaRepo; // corrigido nome da variável

    @Autowired
    private HistoricoRepository historicoRepo; // corrigido nome da variável

    private static final double LIMITE_NIVEL_CRITICO = 3.0;

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

        if (salvo.getNivelAgua() > LIMITE_NIVEL_CRITICO) {
            // Cria Alerta
            Alerta alerta = new Alerta();
            alerta.setMensagem("Nível de água crítico: " + salvo.getNivelAgua());
            alerta.setTipo("PERIGO");
            alerta.setDataAlerta(java.time.LocalDateTime.now());
            alertaRepo.save(alerta);

            // Registra no histórico
            Historico historico = new Historico();
            historico.setAcao("Alerta gerado devido ao nível crítico do sensor.");
            historico.setOrigem("Sensor ID: " + salvo.getId());
            historico.setDataHora(java.time.LocalDateTime.now());
            historicoRepo.save(historico);
        }

        return toDTO(salvo);
    }

    public List<SensorDTO> listar() {
        List<Sensor> sensores = repo.findAll();
        return sensores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
