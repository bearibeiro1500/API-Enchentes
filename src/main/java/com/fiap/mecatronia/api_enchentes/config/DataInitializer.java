package com.fiap.mecatronia.api_enchentes.config;

import com.fiap.mecatronia.api_enchentes.model.Sensor;
import com.fiap.mecatronia.api_enchentes.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public void run(String... args) {
        Sensor leitura = new Sensor();
        leitura.setNivelAgua(1.5);
        leitura.setClima("Nublado");
        leitura.setDataLeitura(LocalDateTime.now());

        sensorRepository.save(leitura);
    }
}