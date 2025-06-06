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
    public void run(String... args) throws Exception {
        if(sensorRepository.count() == 0) {
            Sensor sensor = new Sensor();
            sensor.setClima("Nublado");
            sensor.setNivelAgua(2.3);
            sensor.setDataLeitura(LocalDateTime.now());
            sensorRepository.save(sensor);
        }
    }
}