package com.bancopan.cloud9.bluebank.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name = "tb_transacoes")
public class TransacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numeroDaTransacao;

    @ManyToOne
    @JoinColumn(name = "conta_de_origem")
    private ContaCorrenteModel contaDeOrigem;

    @ManyToOne
    @JoinColumn(name = "conta_de_destino")
    private ContaCorrenteModel contaDeDestino;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDaTransacao = new java.sql.Date(System.currentTimeMillis());

    private Double valorDaTransacao;

    public TransacaoModel() {
    }

    public TransacaoModel(Long numeroDaTransacao, ContaCorrenteModel contaDeOrigem,
                          ContaCorrenteModel contaDeDestino, Date dataDaTransacao, Double valorDaTransacao) {
        this.numeroDaTransacao = numeroDaTransacao;
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

//    public void pagar(BigDecimal valorPagamento) {
//        ContaCorrenteModel contaCorrenteOrigem = new ContaCorrenteModel();
//        if(contaCorrenteOrigem.getSaldoContaCorrente().compareTo(valorPagamento) == 1){
//            contaCorrenteOrigem.getSaldoContaCorrente();
//        }else{
//            contaCorrenteOrigem.setSaldoContaCorrente(contaCorrenteOrigem.getSaldoContaCorrente().subtract(valorPagamento));
//        }
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoModel that = (TransacaoModel) o;
        return numeroDaTransacao.equals(that.numeroDaTransacao) && contaDeOrigem.equals(that.contaDeOrigem) && contaDeDestino.equals(that.contaDeDestino) && dataDaTransacao.equals(that.dataDaTransacao) && valorDaTransacao.equals(that.valorDaTransacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroDaTransacao, contaDeOrigem, contaDeDestino, dataDaTransacao, valorDaTransacao);
    }
}
