package com.bancopan.cloud9.bluebank.enums;

public enum TipoCliente {

    PESSOAFISICA("PessoaFisica"),
    PESSOAJURIDICA("PessoaJuridica");

    private final String tipoCliente;

    TipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }
}
