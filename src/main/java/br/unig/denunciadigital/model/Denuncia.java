package br.unig.denunciadigital.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "denuncias")
public class Denuncia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String faixaEtaria;
    private String periodoUso;
    private String motivosUso;
    private String aplicativos;
    private String tipoViolacao;
    private String sabeDenunciar;
    private String buscouApoio;
    private Integer sensacaoSeguranca;
    private String relato;

    private LocalDateTime dataCriacao = LocalDateTime.now();

    // Construtor vazio (obrigatório para o JPA)
    public Denuncia() {
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getPeriodoUso() {
        return periodoUso;
    }

    public void setPeriodoUso(String periodoUso) {
        this.periodoUso = periodoUso;
    }

    public String getMotivosUso() {
        return motivosUso;
    }

    public void setMotivosUso(String motivosUso) {
        this.motivosUso = motivosUso;
    }

    public String getAplicativos() {
        return aplicativos;
    }

    public void setAplicativos(String aplicativos) {
        this.aplicativos = aplicativos;
    }

    public String getTipoViolacao() {
        return tipoViolacao;
    }

    public void setTipoViolacao(String tipoViolacao) {
        this.tipoViolacao = tipoViolacao;
    }

    public String getSabeDenunciar() {
        return sabeDenunciar;
    }

    public void setSabeDenunciar(String sabeDenunciar) {
        this.sabeDenunciar = sabeDenunciar;
    }

    public String getBuscouApoio() {
        return buscouApoio;
    }

    public void setBuscouApoio(String buscouApoio) {
        this.buscouApoio = buscouApoio;
    }

    public Integer getSensacaoSeguranca() {
        return sensacaoSeguranca;
    }

    public void setSensacaoSeguranca(Integer sensacaoSeguranca) {
        this.sensacaoSeguranca = sensacaoSeguranca;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
