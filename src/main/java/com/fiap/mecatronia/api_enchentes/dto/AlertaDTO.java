package com.fiap.mecatronia.api_enchentes.dto;

import java.time.LocalDateTime;

public class AlertaDTO {
    private Long id;
    private String mensagem;
    private String tipo;
    private LocalDateTime dataAlerta;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public LocalDateTime getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(LocalDateTime dataAlerta) { this.dataAlerta = dataAlerta; }
}
