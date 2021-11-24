package com.bancopan.cloud9.bluebank.enums;

public enum Estado {

    AM ("AMAZONAS"),
    AL("ALAGOAS"),
    AC("ACRE"),
    AP("AMAPA"),
    BA("BAHIA"),
    PA("PARA"),
    MT("MATO GROSSO"),
    MG("MINAS GERAIS"),
    MS("MATO GROSSO DO SUL"),
    GO("GOIAS"),
    MA("MARANHAO"),
    RS("RIO GRANDE DO SUL"),
    TO("TOCANTINS"),
    PI("PIAUI"),
    SP("SÃO PAULO"),
    RO("RONDONIA"),
    RR("RORAIMA"),
    PR("PARANA"),
    CE("CEARA"),
    PE("PERNANBUCO"),
    SC("SANTA CATARINA"),
    PB("PARAIBA"),
    RN("RIO GRANDE DO NORTE"),
    ES("ESPIRITO SANTO"),
    RJ("RIO DE JANEIRO"),
    SE("SERGIPE"),
    DF("DISTRITO FEDERAL");

    private String escrita;

    Estado(String escrita) {
        this.escrita = escrita;
    }

    public String getEscrita(){
        return escrita;
    }

}
