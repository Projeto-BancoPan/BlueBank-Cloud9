package com.bancopan.cloud9.bluebank.enums;

public enum TipoCliente {

    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2,"Pessoa Jurídica");

    private Integer codigo;
    private String descricao;


    TipoCliente(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente tipoClienteEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(TipoCliente descricaoEnum : TipoCliente.values()) {
            if(codigo.equals(descricaoEnum.getCodigo())) {
                return descricaoEnum;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }

}
