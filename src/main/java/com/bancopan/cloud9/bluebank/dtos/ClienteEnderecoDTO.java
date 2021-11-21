package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteEnderecoDTO {

    private Long idCliente;
    private TipoCliente tipoCliente;
    private String nome;
    private EnderecoModel endereco;

    public ClienteEnderecoDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getIdCliente();
        this.tipoCliente = clienteModel.getTipoCliente();
        this.nome = clienteModel.getNome();
        this.endereco = clienteModel.getEnderecoModel();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public TipoCliente getTipoCliente() { return tipoCliente; }

    public String getNome() {
        return nome;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

}
