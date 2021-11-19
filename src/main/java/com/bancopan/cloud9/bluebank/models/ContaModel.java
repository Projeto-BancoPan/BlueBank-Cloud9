package com.bancopan.cloud9.bluebank.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ContaModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	
	private String agencia;
	
	private Date dataDeAbertura;
	
	private Date dataDeEncerramento;
	
	private Long saldo;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Long getSaldo() {
		return saldo;
	}

	public void setSaldo(Long saldo) {
		this.saldo = saldo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
