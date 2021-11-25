package com.bancopan.cloud9.bluebank.enums;

public enum Agencia {

    AGENCIA1("1"),
    AGENCIA2("2"),
    AGENCIA3("3");

    private String numeracao;

    Agencia(String numeracao) {
        this.numeracao = numeracao;
    }

    public String getNumeracao(){
        return numeracao;
    }

}
