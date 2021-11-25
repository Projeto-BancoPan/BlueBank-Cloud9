package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

public class ClienteContatoDTO {

    private Long idCliente;
    private TipoCliente tipoCliente;
    private String nome;
    private String email;
    private String telefone;

    public ClienteContatoDTO(ClienteModel clienteModel) {
        this.idCliente = clienteModel.getIdCliente();
        this.tipoCliente = clienteModel.getTipoCliente();
        this.nome = clienteModel.getNome();
        this.email = clienteModel.getEmail();
        this.telefone = clienteModel.getTelefone();
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public TipoCliente getTipoCliente() { return tipoCliente;}

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}
