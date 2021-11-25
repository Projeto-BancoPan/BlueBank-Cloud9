package com.bancopan.cloud9.bluebank.models;


import com.bancopan.cloud9.bluebank.enums.Agencia;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity(name="tb_contas_corrente")
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



	public ContaCorrenteModel() {
	}

	public ContaCorrenteModel(Date dataDeAbertura, BigDecimal saldoContaCorrente, Long conta, Agencia agencia, ContaPoupancaModel contaPoupancaModel) {
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
}
