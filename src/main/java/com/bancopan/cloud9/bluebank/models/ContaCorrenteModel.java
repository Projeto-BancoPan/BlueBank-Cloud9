package com.bancopan.cloud9.bluebank.models;

<<<<<<< HEAD
import com.bancopan.cloud9.bluebank.enums.Agencia;
import com.bancopan.cloud9.bluebank.superclasses.ContaModel;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name="tb_contas_corrente")
=======

import com.bancopan.cloud9.bluebank.enums.Agencia;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity(name = "tb_contas_corrente")
>>>>>>> featureTransacoes
public class ContaCorrenteModel extends ContaModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long conta;

	@Column
	@Enumerated(EnumType.STRING)
	private Agencia agencia;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "conta_poupanca", unique = true)
	private ContaPoupancaModel contaPoupancaModel;

<<<<<<< HEAD
	public ContaCorrenteModel() {
	}

	public ContaCorrenteModel(Date dataDeAbertura, BigDecimal saldoContaCorrente, Long conta, Agencia agencia, ContaPoupancaModel contaPoupancaModel) {
=======
	@OneToMany(mappedBy = "contaDeOrigem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TransacaoModel> transacoesFeitas;

	@OneToMany(mappedBy = "contaDeDestino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<TransacaoModel> transacoesRecebidas;

	public ContaCorrenteModel() {
	}

	public ContaCorrenteModel(Date dataDeAbertura, Double saldoContaCorrente, Long conta, Agencia agencia, ContaPoupancaModel contaPoupancaModel) {
>>>>>>> featureTransacoes
		super(dataDeAbertura, saldoContaCorrente);
		this.conta = conta;
		this.agencia = agencia;
		this.contaPoupancaModel = contaPoupancaModel;
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

	public ContaPoupancaModel getContaPoupancaModel() {
		return contaPoupancaModel;
	}

	public void setContaPoupancaModel(ContaPoupancaModel contaPoupancaModel) {
		this.contaPoupancaModel = contaPoupancaModel;
	}

<<<<<<< HEAD
=======

	public void pagar(Double valor) {
		if (this.getSaldoContaCorrente() < valor) {
			this.getSaldoContaCorrente();
		} else {
			Double novoSaldo = this.getSaldoContaCorrente() - valor;
			this.setSaldoContaCorrente(novoSaldo);
		}
	}

	public void depositar(Double valor) {
		Double novoSaldo = this.getSaldoContaCorrente() + valor;
		this.setSaldoContaCorrente(novoSaldo);
	}

	public void trasnferir(ContaCorrenteModel contaDestino, Double valor) {
		this.pagar(valor);
		contaDestino.depositar(valor);
	}

//	@Transactional
//	public void pagar(Double valor) {
//		if (this.getSaldoContaCorrente() < valor) {
//			this.getSaldoContaCorrente();
//		} else {
//			Double novoSaldo = this.getSaldoContaCorrente() - valor;
//			this.setSaldoContaCorrente(novoSaldo);
//		}
//	}

//	public void transferir(Double valor, ContaCorrente contaCorrente){
//		if (this.saldo < valor) {
//			this.saldo = saldo;
//		} else {
//			Double novoSaldo = saldo - valor;
//			this.saldo = novoSaldo;
//			contaCorrente.setSaldo(contaCorrente.getSaldo() + valor);
//		}


>>>>>>> featureTransacoes
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		ContaCorrenteModel that = (ContaCorrenteModel) o;
		return conta.equals(that.conta) && agencia == that.agencia && contaPoupancaModel.equals(that.contaPoupancaModel);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), conta, agencia, contaPoupancaModel);
	}
<<<<<<< HEAD
}
=======
}
>>>>>>> featureTransacoes
