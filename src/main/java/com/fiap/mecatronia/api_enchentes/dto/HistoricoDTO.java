package com.fiap.mecatronia.api_enchentes.dto;

import java.time.LocalDateTime;

public class HistoricoDTO {
    private Long id;
    private String acao;
    private String origem;
    private LocalDateTime dataHora;

    // Getters e setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAcao() { return acao; }
    public void setAcao(String acao) { this.acao = acao; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}
