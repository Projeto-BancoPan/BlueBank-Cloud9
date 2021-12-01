package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteModelDTO {

    private Long idCliente;
    private TipoCliente tipoCliente;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoModel endereco;
    private Double renda;
    private Long conta;
    private Date dataDeAbertura;
    private Double saldoDaConta;

    public ClienteModelDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getIdCliente();
        this.tipoCliente = clienteModel.getTipoCliente();
        this.nome = clienteModel.getNome();
        this.email = clienteModel.getEmail();
        this.telefone = clienteModel.getTelefone();
        this.endereco = clienteModel.getEnderecoModel();
        this.renda = clienteModel.getRenda();
        this.conta = clienteModel.getContaCorrenteModel().getConta();
        this.dataDeAbertura = clienteModel.getContaCorrenteModel().getDataDeAbertura();
        this.saldoDaConta = clienteModel.getContaCorrenteModel().getSaldoDaConta();
        this.renda = clienteModel.getRenda();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }

    public Double getRenda() {
        return renda;
    }

    public void setRenda(Double renda) {
        this.renda = renda;
    }

    public Long getConta() {
        return conta;
    }

    public void setConta(Long conta) {
        this.conta = conta;
    }

    public Date getDataDeAbertura() {
        return dataDeAbertura;
    }

    public void setDataDeAbertura(Date dataDeAbertura) {
        this.dataDeAbertura = dataDeAbertura;
    }

    public Double getSaldoDaConta() {
        return saldoDaConta;
    }

    public void setSaldoDaConta(Double saldoDaConta) {
        this.saldoDaConta = saldoDaConta;
    }

    public static List<ClienteModelDTO> converteParaDTO(List<ClienteModel> clienteModelList) {
        return clienteModelList.stream().map(clienteModel -> new ClienteModelDTO(clienteModel)).collect(Collectors.toList());
    }
}
