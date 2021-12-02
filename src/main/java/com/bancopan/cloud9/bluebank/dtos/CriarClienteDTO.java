package com.bancopan.cloud9.bluebank.dtos;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;
import com.bancopan.cloud9.bluebank.models.ClienteModel;
import com.bancopan.cloud9.bluebank.models.ContaCorrenteModel;
import com.bancopan.cloud9.bluebank.models.EnderecoModel;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

public class CriarClienteDTO {

    private TipoCliente tipoCliente;
    private String nome;
    private String email;
    private String telefone;
    private CriarEnderecoDTO endereco;
    private CriarContaCorrenteDTO contaCorrente;
    private Double renda;

    public CriarClienteDTO(TipoCliente tipoCliente, String nome,
                           String email, String telefone, CriarEnderecoDTO endereco,
                           CriarContaCorrenteDTO contaCorrente, Double renda) {
        this.tipoCliente = tipoCliente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.contaCorrente = contaCorrente;
        this.renda = renda;
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

    public CriarEnderecoDTO getEndereco() {
        return endereco;
    }

    public CriarContaCorrenteDTO getContaCorrente() {
        return contaCorrente;
    }

    public Double getRenda() {
        return renda;
    }

    public static ClienteModel converteParaModel(CriarClienteDTO criarClienteDTO) {
        ClienteModel clienteModel = new ClienteModel();
        EnderecoModel enderecoModel  = CriarEnderecoDTO.converteParaModel(criarClienteDTO.getEndereco());
        ContaCorrenteModel contaCorrenteModel = CriarContaCorrenteDTO.converteParaModel(criarClienteDTO.getContaCorrente());
        clienteModel.setNome(criarClienteDTO.getNome());
        clienteModel.setEnderecoModel(enderecoModel);
        clienteModel.setTipoCliente(criarClienteDTO.getTipoCliente());
        clienteModel.setEmail(criarClienteDTO.getEmail());
        clienteModel.setTelefone(criarClienteDTO.getTelefone());
        clienteModel.setRenda(criarClienteDTO.getRenda());
        clienteModel.setContaCorrenteModel(contaCorrenteModel);

        return clienteModel;
    }
}

