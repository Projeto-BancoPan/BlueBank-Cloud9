package com.bancopan.cloud9.bluebank.enums;

public enum TipoTransacao {
    TRANSFERENCIA(1, "Transferencia"),
    PAGAMENTO(2,"Pagamento");

    private Integer codigo;
    private String descricao;


    TipoTransacao(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoTransacao tipoTransacaoEnum(Integer codigo) {
        if(codigo == null) {
            return null;
        }
        for(TipoTransacao descricaoEnum : TipoTransacao.values()) {
            if(codigo.equals(descricaoEnum.getCodigo())) {
                return descricaoEnum;
            }
        }
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }
}