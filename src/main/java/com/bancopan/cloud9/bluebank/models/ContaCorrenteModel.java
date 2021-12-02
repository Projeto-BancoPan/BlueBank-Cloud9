package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.Agencia;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "tb_contas_corrente")
public class ContaCorrenteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long conta;

    @Column
    @Enumerated(EnumType.STRING)
    private Agencia agencia;

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeAbertura = new java.sql.Date(System.currentTimeMillis());

    @Column
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataDeEncerramento;

    @Column
    @NotNull
    private Double saldoDaConta;

    @OneToMany(mappedBy = "contaDeOrigem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TransacaoModel> transacoesFeitas;

    @OneToMany(mappedBy = "contaDeDestino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<TransacaoModel> transacoesRecebidas;

    public ContaCorrenteModel() {
    }

    public ContaCorrenteModel(Long conta, Agencia agencia, Date dataDeAbertura, Double saldoDaConta) {
        this.conta = conta;
        this.agencia = agencia;
        this.dataDeAbertura = dataDeAbertura;
        this.saldoDaConta = saldoDaConta;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Date getDataDeEncerramento() {
        return dataDeEncerramento;
    }

    public void setDataDeEncerramento(Date dataDeEncerramento) {
        this.dataDeEncerramento = dataDeEncerramento;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setSaldoDaConta(Double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }

    public List<TransacaoModel> getTransacoesFeitas() {
        return transacoesFeitas;
    }

    public void setTransacoesFeitas(List<TransacaoModel> transacoesFeitas) {
        this.transacoesFeitas = transacoesFeitas;
    }

//    public List<TransacaoModel> getTransacoesRecebidas() {
//        return transacoesRecebidas;
//    }
//
//    public void setTransacoesRecebidas(List<TransacaoModel> transacoesRecebidas) {
//        this.transacoesRecebidas = transacoesRecebidas;
//    }

    public void sacar(Double valor) {
        if (this.getSaldoDaConta() < valor) {
            this.getSaldoDaConta();
        } else {
            Double novoSaldo = this.getSaldoDaConta() - valor;
            this.setSaldoDaConta(novoSaldo);
        }
    }

    public void depositar(Double valor) {
        Double novoSaldo = this.getSaldoDaConta() + valor;
        this.setSaldoDaConta(novoSaldo);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCorrenteModel that = (ContaCorrenteModel) o;
        return Objects.equals(conta, that.conta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conta);
    }
}
