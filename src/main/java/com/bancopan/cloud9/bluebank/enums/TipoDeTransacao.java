package com.bancopan.cloud9.bluebank.enums;

public enum TipoDeTransacao {

    PAGAMENTO("PAGAMENTO"),
    DEPOSITO("DEPÓSITO"),
    TRANSFERENCIA("TRANSFERÊNCIA");

    private String transacao;

    TipoDeTransacao(String transacao) {
        this.transacao = transacao;
    }

    public String getTransacao() {
        return transacao;
    }
}
