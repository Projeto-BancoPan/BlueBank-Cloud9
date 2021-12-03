package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.TipoDeTransacao;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tb_transacoes")
public class TransacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroDaTransacao;

    @Column
    @Enumerated(EnumType.STRING)
    private TipoDeTransacao tipoDeTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_de_origem")
    @JsonIgnore
    private ContaCorrenteModel contaDeOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_de_destino")
    @JsonIgnore
    private ContaCorrenteModel contaDeDestino;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDaTransacao = new java.sql.Date(System.currentTimeMillis());

    @Column
    private Double valorDaTransacao;

    public TransacaoModel(){
    }

    public TransacaoModel(Long numeroDaTransacao, TipoDeTransacao tipoDeTransacao, ContaCorrenteModel contaDeOrigem,
                          ContaCorrenteModel contaDeDestino, Date dataDaTransacao, Double valorDaTransacao) {
        this.numeroDaTransacao = numeroDaTransacao;
        this.tipoDeTransacao = tipoDeTransacao;
        this.contaDeOrigem = contaDeOrigem;
        this.contaDeDestino = contaDeDestino;
        this.dataDaTransacao = dataDaTransacao;
        this.valorDaTransacao = valorDaTransacao;
    }

    public Long getNumeroDaTransacao() {
        return numeroDaTransacao;
    }

    public void setNumeroDaTransacao(Long numeroDaTransacao) {
        this.numeroDaTransacao = numeroDaTransacao;
    }

    public ContaCorrenteModel getContaDeOrigem() {
        return contaDeOrigem;
    }

    public void setContaDeOrigem(ContaCorrenteModel contaDeOrigem) {
        this.contaDeOrigem = contaDeOrigem;
    }

    public TipoDeTransacao getTipoDeTransacao() {
        return tipoDeTransacao;
    }

    public void setTipoDeTransacao(TipoDeTransacao tipoDeTransacao) {
        this.tipoDeTransacao = tipoDeTransacao;
    }

    public ContaCorrenteModel getContaDeDestino() {
        return contaDeDestino;
    }

    public void setContaDeDestino(ContaCorrenteModel contaDeDestino) {
        this.contaDeDestino = contaDeDestino;
    }

    public Date getDataDaTransacao() {
        return dataDaTransacao;
    }

    public void setDataDaTransacao(Date dataDaTransacao) {
        this.dataDaTransacao = dataDaTransacao;
    }

    public Double getValorDaTransacao() {
        return valorDaTransacao;
    }

    public void setValorDaTransacao(Double valorDaTransacao) {
        this.valorDaTransacao = valorDaTransacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoModel that = (TransacaoModel) o;
        return numeroDaTransacao.equals(that.numeroDaTransacao) && tipoDeTransacao == that.tipoDeTransacao && contaDeOrigem.equals(that.contaDeOrigem) && contaDeDestino.equals(that.contaDeDestino) && dataDaTransacao.equals(that.dataDaTransacao) && valorDaTransacao.equals(that.valorDaTransacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDaTransacao, tipoDeTransacao, contaDeOrigem, contaDeDestino, dataDaTransacao, valorDaTransacao);
    }
}
