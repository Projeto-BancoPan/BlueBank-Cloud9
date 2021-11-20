package com.bancopan.cloud9.bluebank.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name="tb_conta_poupanca")
public class ContaPoupancaModel extends ContaModel implements Serializable
{
	
	private Long numeroConta;
	
	private String agencia;

	

	public ContaPoupancaModel(Long numeroConta, String agencia, Date dataDeAbertura, Date dataDeEncerramento,
			Long saldo) {
		super(numeroConta, agencia, dataDeAbertura, dataDeEncerramento, saldo);
		// TODO Auto-generated constructor stub
	}

	
	public ContaPoupancaModel(Long numeroConta, String agencia, Date dataDeAbertura, Date dataDeEncerramento,
			Long saldo, Long numeroConta2, String agencia2) {
		super(numeroConta, agencia, dataDeAbertura, dataDeEncerramento, saldo);
		numeroConta = numeroConta2;
		agencia = agencia2;
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
	
}
	
	
	
	