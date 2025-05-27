package com.fiap.mecatronia.api_enchentes.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double nivelAgua;
    private String clima;

    private LocalDateTime dataLeitura;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(double nivelAgua) { this.nivelAgua = nivelAgua; }

    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }

    public LocalDateTime getDataLeitura() { return dataLeitura; }
    public void setDataLeitura(LocalDateTime dataLeitura) { this.dataLeitura = dataLeitura; }
}
