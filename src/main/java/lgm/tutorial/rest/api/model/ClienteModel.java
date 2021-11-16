package lgm.tutorial.rest.api.model;

import javax.persistence.*;

@Entity(name = "cliente")
public class ClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer codigo;

    @Column(nullable = false, length = 50)
    public String nome;

    @Column(nullable = false, length = 100)
    public String endereco;

    @Column(nullable = false, length = 50)
    public String telefone;

    @Column(nullable = false, length = 50)
    public String email;

    @Column(nullable = false, length = 30)
    public Integer renda;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    public Integer getRenda() {
        return renda;
    }

    public void setRenda(Integer renda) {
        this.renda = renda;
    }
}

