package com.bancopan.cloud9.bluebank.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@MappedSuperclass
public abstract class ContaModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeAbertura = new java.sql.Date(System.currentTimeMillis());

	@Column
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataDeEncerramento;

	@Column
	private BigDecimal saldoContaCorrente = new BigDecimal(0.00).setScale(2);;

	public ContaModel(){
	}

	public ContaModel(Date dataDeAbertura, BigDecimal saldoContaCorrente) {
		this.dataDeAbertura = dataDeAbertura;
		this.saldoContaCorrente = saldoContaCorrente;
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

	public BigDecimal getSaldoContaCorrente() {
		return saldoContaCorrente;
	}

	public void setSaldoContaCorrente(BigDecimal saldoContaCorrente) {
		this.saldoContaCorrente = saldoContaCorrente;
	}


	public void depositar(BigDecimal valorPagamento) {

		saldoContaCorrente = saldoContaCorrente.add(valorPagamento) ;

	}

	public void pagar(BigDecimal valorPagamento) {

		saldoContaCorrente = saldoContaCorrente.subtract(valorPagamento);

	}

	public void transferir(ContaCorrenteModel contaDestino,BigDecimal valorPagamento) {

		this.pagar(valorPagamento);
		contaDestino.depositar(valorPagamento);

	}




	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ContaModel that = (ContaModel) o;
		return dataDeAbertura.equals(that.dataDeAbertura) && dataDeEncerramento.equals(that.dataDeEncerramento) && saldoContaCorrente.equals(that.saldoContaCorrente);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeAbertura, dataDeEncerramento, saldoContaCorrente);
	}
}
