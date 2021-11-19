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
    public ClienteModel(){
    }

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;

    @Column(nullable = false)
    public String nome;

    @Embedded
    private EnderecoModel enderecoModel;

//    @Enumerated(EnumType.STRING)
//    @NotNull
//    private TipoCliente tipoCliente;
//
//    private Integer tipoCliente;


    @Column(nullable = false, length = 100)
    public String telefone;

    @Column(nullable = false, length = 100)
    public String email;

    @Column(nullable = false)
    public BigDecimal renda;

<<<<<<< HEAD
    //    public ClienteModel(Long codigo, String nome, Integer tipoCliente, String telefone, String email, BigDecimal renda) {
//        this.codigo = codigo;
//        this.nome = nome;
//       this.tipoCliente = tipoCliente;
//        this.telefone = telefone;
//        this.email = email;
//        this.renda = renda;
//    }
=======
    public ClienteModel(){
    }

    public ClienteModel(Long codigo, String nome, Integer tipoCliente, String telefone, String email, BigDecimal renda) {
        this.codigo = codigo;
        this.nome = nome;
        this.tipoCliente = tipoCliente;
        this.telefone = telefone;
        this.email = email;
        this.renda = renda;
    }
>>>>>>> 9ab36ee49dfbc28b7622dbce7c5a48d3cf2cd499

    public Long getCodigo() {

        return codigo;
    }

    public void setCodigo(Long codigo) {

        this.codigo = codigo;
    }

    public String getNome() {

        return nome;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

//    public TipoCliente getTipo() {
//
//        return TipoCliente.tipoClienteEnum(tipoCliente);
//    }


//    public void setTipoCliente(TipoCliente tipoCliente) {
//
//
////    public void setTipo(Integer tipoCliente) {
////
////        this.tipoCliente = tipoCliente;
////    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ClienteModel that = (ClienteModel) o;
//        return codigo.equals(that.codigo) && nome.equals(that.nome) && tipoCliente == that.tipoCliente && telefone.equals(that.telefone) && email.equals(that.email) && renda.equals(that.renda);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(codigo, nome, tipoCliente, telefone, email, renda);
//    }
}

