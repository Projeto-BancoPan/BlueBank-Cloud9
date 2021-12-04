package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.Agencia;
import com.bancopan.cloud9.bluebank.enums.TipoDeTransacao;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.TransacaoModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaListaDeTransacoesDTO {

    private Long conta;
    private Agencia agencia;
    private List<TransacaoModel> transacoesFeitas;
    private List<TransacaoModel> transacoesRecebidas;


    public ConsultaListaDeTransacoesDTO(ContaCorrenteModel contaCorrenteModel) {
        this.conta = contaCorrenteModel.getConta();
        this.agencia = contaCorrenteModel.getAgencia();
        this.transacoesFeitas = contaCorrenteModel.getTransacoesFeitas();
        this.transacoesRecebidas = contaCorrenteModel.getTransacoesRecebidas();
    }

    public Long getConta() {
        return conta;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public List<TransacaoModel> getTransacoesFeitas() {
        return transacoesFeitas;
    }

    public List<TransacaoModel> getTransacoesRecebidas() {
        return transacoesRecebidas;
    }

    public static List<ConsultaListaDeTransacoesDTO> converteParaDTO(List<ContaCorrenteModel> contaCorrenteModelList) {
        return contaCorrenteModelList.stream().map(transacoes -> new ConsultaListaDeTransacoesDTO(transacoes)).collect(Collectors.toList());
    }
}
