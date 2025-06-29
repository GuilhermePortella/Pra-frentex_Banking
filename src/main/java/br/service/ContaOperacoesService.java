package br.service;

import br.domain.model.operacao.OperacaoConta;
import br.domain.model.operacao.TipoOperacao;
import br.domain.model.usuarios.Usuario;
import br.service.audit.AuditLogger;
import br.service.audit.LoggedTransaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContaOperacoesService {
    private static final Logger logger = LoggerFactory.getLogger(ContaOperacoesService.class);
    private final AuditLogger auditLogger = new AuditLogger();

    private Map<String, BigDecimal> saldoContas = new HashMap<>();
    private Map<String, List<OperacaoConta>> historicoOperacoes = new HashMap<>();
    private Set<String> numerosContaExistentes = new HashSet<>();

    public String gerarNumeroConta() {
        Random random = new Random();
        String numeroConta;
        do {
            numeroConta = String.format("%06d-%d", 
                random.nextInt(1000000), 
                random.nextInt(10));
        } while (numerosContaExistentes.contains(numeroConta));
        
        numerosContaExistentes.add(numeroConta);
        return numeroConta;
    }

    public void criarConta(String numeroConta, BigDecimal saldoInicial) {
        if (saldoContas.containsKey(numeroConta)) {
            throw new IllegalArgumentException("Conta já existe");
        }
        saldoContas.put(numeroConta, saldoInicial);
        historicoOperacoes.put(numeroConta, new ArrayList<>());
        registrarOperacao(numeroConta, TipoOperacao.DEPOSITO, saldoInicial, "Saldo inicial");
    }

    public void depositar(String numeroConta, BigDecimal valor) {
        validarConta(numeroConta);
        validarValor(valor);
        
        BigDecimal novoSaldo = saldoContas.get(numeroConta).add(valor);
        saldoContas.put(numeroConta, novoSaldo);
        registrarOperacao(numeroConta, TipoOperacao.DEPOSITO, valor, "Depósito em conta");
        
        logger.info("Depósito realizado: Conta {}, Valor {}", numeroConta, valor);
    }

    public void sacar(String numeroConta, BigDecimal valor) {
        validarConta(numeroConta);
        validarValor(valor);
        
        BigDecimal saldoAtual = saldoContas.get(numeroConta);
        if (saldoAtual.compareTo(valor) < 0) {
            throw new IllegalStateException("Saldo insuficiente");
        }
        
        saldoContas.put(numeroConta, saldoAtual.subtract(valor));
        registrarOperacao(numeroConta, TipoOperacao.SAQUE, valor, "Saque em conta");
        
        logger.info("Saque realizado: Conta {}, Valor {}", numeroConta, valor);
    }

    @LoggedTransaction
    public void transferir(String contaOrigem, String contaDestino, BigDecimal valor) {
        try {
            validarConta(contaOrigem);
            validarConta(contaDestino);
            validarValor(valor);
            
            sacar(contaOrigem, valor);
            depositar(contaDestino, valor);
            
            auditLogger.logOperacao(
                contaOrigem,
                "TRANSFERENCIA",
                String.format("Transferência de %s para %s, valor: %s", 
                    contaOrigem, contaDestino, valor)
            );
            
        } catch (Exception e) {
            auditLogger.logErro(contaOrigem, "TRANSFERENCIA_ERRO", e);
            throw e;
        }
    }

    public void pagarBoleto(String numeroConta, BigDecimal valor, String codigoBoleto) {
        validarConta(numeroConta);
        validarValor(valor);
        
        sacar(numeroConta, valor);
        registrarOperacao(numeroConta, TipoOperacao.PAGAMENTO_BOLETO, valor.negate(),
            "Pagamento de boleto: " + codigoBoleto);
        
        logger.info("Boleto pago: Conta {}, Valor {}, Código {}", 
            numeroConta, valor, codigoBoleto);
    }

    public List<OperacaoConta> gerarExtrato(String numeroConta) {
        validarConta(numeroConta);
        return new ArrayList<>(historicoOperacoes.get(numeroConta));
    }

    public BigDecimal consultarSaldo(String numeroConta) {
        validarConta(numeroConta);
        return saldoContas.get(numeroConta);
    }

    private void validarConta(String numeroConta) {
        if (!saldoContas.containsKey(numeroConta)) {
            throw new IllegalArgumentException("Conta não encontrada: " + numeroConta);
        }
    }

    private void validarValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor deve ser maior que zero");
        }
    }

    private void registrarOperacao(String numeroConta, TipoOperacao tipo, 
        BigDecimal valor, String descricao) {
        OperacaoConta operacao = new OperacaoConta(numeroConta, tipo, valor, descricao);
        historicoOperacoes.get(numeroConta).add(operacao);
    }
}