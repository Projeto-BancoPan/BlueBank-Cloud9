package com.bancopan.cloud9.bluebank.models;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;

@Entity(name="tb_conta_poupanca")
public class ContaPoupancaModel extends ContaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long conta_poupanca;

	public ContaPoupancaModel() {
	}

	public ContaPoupancaModel(Date dataDeAbertura, BigDecimal saldoContaCorrente) {
		super(dataDeAbertura, saldoContaCorrente);
	}

}
	
	
	
	