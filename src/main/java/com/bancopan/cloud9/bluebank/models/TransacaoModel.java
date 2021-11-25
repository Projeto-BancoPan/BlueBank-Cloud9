package com.bancopan.cloud9.bluebank.models;

import com.bancopan.cloud9.bluebank.enums.TipoTransacao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class TransacaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    private Date dataDeTransação;

    @ManyToMany
    private List<ContaCorrenteModel> contaCorrenteMode = new ArrayList<>();

    private BigDecimal valorTransacao;

    private TipoTransacao tipoTransacao;

    public TransacaoModel() {
    }

    public TransacaoModel(Long id, Date dataDeTransação, List<ContaCorrenteModel> contaCorrenteMode, BigDecimal valorTransacao, TipoTransacao tipoTransacao) {
        this.id = id;
        this.dataDeTransação = dataDeTransação;
        this.contaCorrenteMode = contaCorrenteMode;
        this.valorTransacao = valorTransacao;
        this.tipoTransacao = tipoTransacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransacaoModel that = (TransacaoModel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}