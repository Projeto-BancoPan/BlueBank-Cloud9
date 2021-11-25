package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.Estado;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_enderecos")
public class EnderecoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEndereco;

    @Column(nullable = false)
    private String logradouro;
    @Column(nullable = false)
    private Integer numero;
    @Column(nullable = false)
    private String complemento;
    @Column(nullable = false)
    private String bairro;
    @Column(nullable = false)
    private String cep;
    @Column(nullable = false)
    private String cidade;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estado estado;

    public EnderecoModel(){
    }

    public EnderecoModel(Long idEndereco, String logradouro, Integer numero, String complemento, String bairro, String cep, String cidade, Estado estado) {
        this.idEndereco = idEndereco;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Long getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Long idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnderecoModel that = (EnderecoModel) o;
        return idEndereco.equals(that.idEndereco) && logradouro.equals(that.logradouro) && numero.equals(that.numero) && complemento.equals(that.complemento) && bairro.equals(that.bairro) && cep.equals(that.cep) && cidade.equals(that.cidade) && estado.equals(that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEndereco, logradouro, numero, complemento, bairro, cep, cidade, estado);
    }
}
