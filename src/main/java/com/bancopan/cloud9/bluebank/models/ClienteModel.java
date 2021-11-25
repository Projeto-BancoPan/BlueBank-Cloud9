package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.TipoCliente;

import javax.persistence.*;
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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private EnderecoModel enderecoModel;

    @Enumerated(EnumType.STRING)
    private TipoCliente tipoCliente;

    @Column(nullable = false, length = 100)
    private String telefone;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false)
    public BigDecimal renda;
    
    @OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	private ContaCorrenteModel contaCorrente;

    public ClienteModel(){

    }

	public ClienteModel(Long idCliente, String nome, EnderecoModel enderecoModel, TipoCliente tipoCliente,
			String telefone, String email, BigDecimal renda, ContaCorrenteModel contaCorrente) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.enderecoModel = enderecoModel;
		this.tipoCliente = tipoCliente;
		this.telefone = telefone;
		this.email = email;
		this.renda = renda;
		this.contaCorrente = contaCorrente;
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

	public ContaCorrenteModel getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(ContaCorrenteModel contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}





	@Override
	public int hashCode() {
		return Objects.hash(contaCorrente, email, enderecoModel, idCliente, nome, renda, telefone, tipoCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteModel other = (ClienteModel) obj;
		return Objects.equals(contaCorrente, other.contaCorrente) && Objects.equals(email, other.email)
				&& Objects.equals(enderecoModel, other.enderecoModel) && Objects.equals(idCliente, other.idCliente)
				&& Objects.equals(nome, other.nome) && Objects.equals(renda, other.renda)
				&& Objects.equals(telefone, other.telefone) && tipoCliente == other.tipoCliente;
	}

   
}

