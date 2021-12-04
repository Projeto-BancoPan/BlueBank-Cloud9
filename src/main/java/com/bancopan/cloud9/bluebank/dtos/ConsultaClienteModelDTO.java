package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ConsultaClienteModelDTO {

    private Long idCliente;
    private TipoCliente tipoCliente;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoModel endereco;
    private Double renda;
    private Long conta;
    private Date dataDeAbertura;
    private Date dataDeEncerramento;
    private Double saldoDaConta;

    public ConsultaClienteModelDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getIdCliente();
        this.tipoCliente = clienteModel.getTipoCliente();
        this.nome = clienteModel.getNome();
        this.email = clienteModel.getEmail();
        this.telefone = clienteModel.getTelefone();
        this.endereco = clienteModel.getEnderecoModel();
        this.renda = clienteModel.getRenda();
        this.conta = clienteModel.getContaCorrenteModel().getConta();
        this.dataDeAbertura = clienteModel.getContaCorrenteModel().getDataDeAbertura();
        this.dataDeEncerramento = clienteModel.getContaCorrenteModel().getDataDeEncerramento();
        this.saldoDaConta = clienteModel.getContaCorrenteModel().getSaldoDaConta();
        this.renda = clienteModel.getRenda();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public Double getRenda() {
        return renda;
    }

    public Long getConta() {
        return conta;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public Date getDataDeEncerramento() {
        return dataDeEncerramento;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public static List<ConsultaClienteModelDTO> converteParaDTO(List<ClienteModel> clienteModelList) {
        return clienteModelList.stream().map(clienteModel -> new ConsultaClienteModelDTO(clienteModel)).collect(Collectors.toList());
    }
}
