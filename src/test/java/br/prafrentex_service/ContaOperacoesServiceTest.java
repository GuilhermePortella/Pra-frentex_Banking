package br.prafrentex_service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.prafrentex_domain.OperacaoConta;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ContaOperacoesServiceTest {
    
    private ContaOperacoesService service;
    private String conta1;
    private String conta2;
    
    @BeforeEach
    void setUp() {
        service = new ContaOperacoesService();
        conta1 = service.gerarNumeroConta();
        conta2 = service.gerarNumeroConta();
        
        service.criarConta(conta1, new BigDecimal("1000.00"));
        service.criarConta(conta2, new BigDecimal("500.00"));
    }
    
    @Test
    void testGerarNumeroConta() {
        String numero1 = service.gerarNumeroConta();
        String numero2 = service.gerarNumeroConta();
        assertNotEquals(numero1, numero2);
    }
    
    @Test
    void testDeposito() {
        service.depositar(conta1, new BigDecimal("500.00"));
        assertEquals(new BigDecimal("1500.00"), service.consultarSaldo(conta1));
    }
    
    @Test
    void testSaque() {
        service.sacar(conta1, new BigDecimal("300.00"));
        assertEquals(new BigDecimal("700.00"), service.consultarSaldo(conta1));
    }
    
    @Test
    void testTransferencia() {
        service.transferir(conta1, conta2, new BigDecimal("300.00"));
        assertEquals(new BigDecimal("700.00"), service.consultarSaldo(conta1));
        assertEquals(new BigDecimal("800.00"), service.consultarSaldo(conta2));
    }
    
    @Test
    void testPagamentoBoleto() {
        service.pagarBoleto(conta1, new BigDecimal("100.00"), "123456789");
        assertEquals(new BigDecimal("900.00"), service.consultarSaldo(conta1));
    }
    
    @Test
    void testGerarExtrato() {
        service.depositar(conta1, new BigDecimal("100.00"));
        service.sacar(conta1, new BigDecimal("50.00"));
        
        List<OperacaoConta> extrato = service.gerarExtrato(conta1);
        assertEquals(3, extrato.size());
    }
    
    @Test
    void testSaldoInsuficiente() {
        assertThrows(IllegalStateException.class, () -> 
            service.sacar(conta1, new BigDecimal("2000.00")));
    }
}
