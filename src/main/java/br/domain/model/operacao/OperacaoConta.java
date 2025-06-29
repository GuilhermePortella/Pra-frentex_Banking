package br.domain.model.operacao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OperacaoConta {
    private String conta;
    private TipoOperacao tipo;
    private BigDecimal valor;
    private LocalDateTime dataHora;
    private String descricao;

    public OperacaoConta(String conta, TipoOperacao tipo, BigDecimal valor, String descricao) {
        this.conta = conta;
        this.tipo = tipo;
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.descricao = descricao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public TipoOperacao getTipo() {
        return tipo;
    }

    public void setTipo(TipoOperacao tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
