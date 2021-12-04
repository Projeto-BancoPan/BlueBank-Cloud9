package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.Estado;
import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class CriarEnderecoDTO {

    private String logradouro;
    private Integer numero;
    private String complemento;
    private String bairro;
    private String cep;
    private String cidade;
    private Estado estado;

    public CriarEnderecoDTO(){
    }
    public CriarEnderecoDTO(String logradouro, Integer numero, String complemento,
                            String bairro, String cep, String cidade, Estado estado) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    public String getCidade() {
        return cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public static EnderecoModel converteParaModel(CriarEnderecoDTO criarEnderecoDTO) {
        EnderecoModel enderecoModel = new EnderecoModel();
        enderecoModel.setLogradouro(criarEnderecoDTO.getLogradouro());
        enderecoModel.setNumero(criarEnderecoDTO.getNumero());
        enderecoModel.setComplemento(criarEnderecoDTO.getComplemento());
        enderecoModel.setBairro(criarEnderecoDTO.getBairro());
        enderecoModel.setCep(criarEnderecoDTO.getCep());
        enderecoModel.setCidade(criarEnderecoDTO.getCidade());
        enderecoModel.setEstado(criarEnderecoDTO.getEstado());

        return enderecoModel;
    }
}

