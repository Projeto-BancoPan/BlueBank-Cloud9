package com.bancopan.cloud9.bluebank.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="tb_conta_corrente")
public class ContaCorrenteModel extends ContaModel implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	private Long numeroConta;
	
	private String agencia;
	
	@Column
	@OneToOne
	@JoinColumn(unique = true)
	private ClienteModel cliente;
	
	@Column
	private Long saldoContaPoupança;

	public ContaCorrenteModel(Long numeroConta, String agencia, Date dataDeAbertura, Date dataDeEncerramento) {
		super(numeroConta, agencia, dataDeAbertura, dataDeEncerramento);
		// TODO Auto-generated constructor stub
	}

	public ContaCorrenteModel(Long numeroConta, String agencia, Date dataDeAbertura, Date dataDeEncerramento,
			Long numeroConta2, String agencia2, ClienteModel cliente, Long saldoContaPoupança) {
		super(numeroConta, agencia, dataDeAbertura, dataDeEncerramento);
		numeroConta = numeroConta2;
		agencia = agencia2;
		this.cliente = cliente;
		this.saldoContaPoupança = saldoContaPoupança;
	}
	
	

	public Long getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public ClienteModel getCliente() {
		return cliente;
	}

	public void setCliente(ClienteModel cliente) {
		this.cliente = cliente;
	}

	public Long getSaldoContaPoupança() {
		return saldoContaPoupança;
	}

	public void setSaldoContaPoupança(Long saldoContaPoupança) {
		this.saldoContaPoupança = saldoContaPoupança;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(agencia, cliente, numeroConta, saldoContaPoupança);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaCorrenteModel other = (ContaCorrenteModel) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(numeroConta, other.numeroConta)
				&& Objects.equals(saldoContaPoupança, other.saldoContaPoupança);
	}
	

	

	
	
	
	
	
	
}
