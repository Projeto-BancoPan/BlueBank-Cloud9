package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteTipoDTO {

    private Long idCliente;
    private TipoCliente tipoCliente;
    private String nome;
    private String email;
    private String telefone;
    private EnderecoModel endereco;

    public ClienteTipoDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getIdCliente();
        this.tipoCliente = clienteModel.getTipoCliente();
        this.nome = clienteModel.getNome();
        this.email = clienteModel.getEmail();
        this.telefone = clienteModel.getTelefone();
        this.endereco = clienteModel.getEnderecoModel();
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

    public static List<ClienteTipoDTO> converteParaDTO(List<ClienteModel> clienteModelList) {
        return clienteModelList.stream().map(clienteModel -> new ClienteTipoDTO(clienteModel)).collect(Collectors.toList());
    }
}

