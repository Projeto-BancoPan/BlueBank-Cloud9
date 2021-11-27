package com.bancopan.cloud9.bluebank.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "tb_conta_poupanca")
public class ContaPoupancaModel extends ContaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long conta_poupanca;

    public ContaPoupancaModel() {
    }

    public ContaPoupancaModel(Date dataDeAbertura, Double saldoContaCorrente) {
        super(dataDeAbertura, saldoContaCorrente);
    }

}
	
	
	
	