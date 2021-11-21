package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_clientes")
public class ClienteModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false)
    private String nome;

    @Embedded
    private EnderecoModel enderecoModel;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Column(nullable = false, length = 100)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    public BigDecimal renda;

    public ClienteModel(){

    }

    public ClienteModel(Long idCliente, String nome, TipoCliente  tipoCliente, String telefone, String email, BigDecimal renda) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.telefone = telefone;
        this.email = email;
        this.renda = renda;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoModel getEnderecoModel() {
        return enderecoModel;
    }

    public void setEnderecoModel(EnderecoModel enderecoModel) {
        this.enderecoModel = enderecoModel;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteModel that = (ClienteModel) o;
        return idCliente.equals(that.idCliente) && nome.equals(that.nome) && enderecoModel.equals(that.enderecoModel) && tipoCliente.equals(that.tipoCliente) && telefone.equals(that.telefone) && email.equals(that.email) && renda.equals(that.renda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente, nome, enderecoModel, tipoCliente, telefone, email, renda);
    }
}

