package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.Agencia;
import com.bancopan.cloud9.bluebank.enums.Estado;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

public class CriarContaCorrenteDTO {

    private Agencia agencia;
    private Double saldoDaConta;


    public CriarContaCorrenteDTO(){

    }

    public CriarContaCorrenteDTO(Agencia agencia, Double saldoDaConta) {
        this.agencia = agencia;
        this.saldoDaConta = saldoDaConta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public static ContaCorrenteModel converteParaModel(CriarContaCorrenteDTO criarContaCorrenteDTO) {
        ContaCorrenteModel contaCorrenteModel = new ContaCorrenteModel();
        contaCorrenteModel.setAgencia(criarContaCorrenteDTO.getAgencia());
        contaCorrenteModel.setSaldoDaConta(criarContaCorrenteDTO.getSaldoDaConta());

        return contaCorrenteModel;
    }
}

