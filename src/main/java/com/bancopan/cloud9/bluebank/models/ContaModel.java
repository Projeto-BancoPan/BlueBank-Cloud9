package com.bancopan.cloud9.bluebank.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class ContaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long numeroConta;
	
	@Column
	private String agencia;
	
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataDeAbertura = new java.sql.Date(System.currentTimeMillis());
	
	@Column
	private Date dataDeEncerramento;

	public ContaModel(Long numeroConta, String agencia, Date dataDeAbertura, Date dataDeEncerramento) {
		super();
		this.numeroConta = numeroConta;
		this.agencia = agencia;
		this.dataDeAbertura = dataDeAbertura;
		this.dataDeEncerramento = dataDeEncerramento;
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



	@Override
	public int hashCode() {
		return Objects.hash(agencia, dataDeAbertura, dataDeEncerramento, numeroConta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContaModel other = (ContaModel) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(dataDeAbertura, other.dataDeAbertura)
				&& Objects.equals(dataDeEncerramento, other.dataDeEncerramento)
				&& Objects.equals(numeroConta, other.numeroConta);
	}

	

	

	
	
	
}
