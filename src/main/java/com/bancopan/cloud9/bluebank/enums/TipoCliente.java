package com.bancopan.cloud9.bluebank.enums;

public enum TipoCliente {

    PESSOAFISICA("PESSOAFISICA"),
    PESSOAJURIDICA("PESSOAJURIDICA");

    private String decricao;

    TipoCliente(String descricao) {
        this.decricao = descricao;
    }

    public String getDecricao(){
        return decricao;
    }

}
