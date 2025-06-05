package com.fiap.mecatronia.api_enchentes.dto;

import java.time.LocalDateTime;

public class SensorDTO {
    private Long id;
    private double nivelAgua;
    private String clima;
    private LocalDateTime dataLeitura;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getNivelAgua() { return nivelAgua; }
    public void setNivelAgua(double nivelAgua) { this.nivelAgua = nivelAgua; }

    public String getClima() { return clima; }
    public void setClima(String clima) { this.clima = clima; }

    public LocalDateTime getDataLeitura() { return dataLeitura; }
    public void setDataLeitura(LocalDateTime dataLeitura) { this.dataLeitura = dataLeitura; }
}
