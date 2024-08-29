/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.prafrentex_service;

import br.prafrentex_domain.ContaPF;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Guilherme
 */
public class AbrirContaPFIT {
    
    public AbrirContaPFIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCpf method, of class AbrirContaPF.
     */
    @Test
    public void testGetCpf() {
        System.out.println("getCpf");
        AbrirContaPF instance = new AbrirContaPF();
        String expResult = "";
        String result = instance.getCpf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarNomeIdadePessoa method, of class AbrirContaPF.
     */
    @Test
    public void testSolicitarNomeIdadePessoa() {
        System.out.println("solicitarNomeIdadePessoa");
        AbrirContaPF instance = new AbrirContaPF();
        instance.solicitarNomeIdadePessoa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarDadosPessoa method, of class AbrirContaPF.
     */
    @Test
    public void testSolicitarDadosPessoa() {
        System.out.println("solicitarDadosPessoa");
        AbrirContaPF instance = new AbrirContaPF();
        instance.solicitarDadosPessoa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of exibirInformacoesPessoa method, of class AbrirContaPF.
     */
    @Test
    public void testExibirInformacoesPessoa() {
        System.out.println("exibirInformacoesPessoa");
        AbrirContaPF instance = new AbrirContaPF();
        instance.exibirInformacoesPessoa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of adicionarContaPF method, of class AbrirContaPF.
     */
    @Test
    public void testAdicionarContaPF() {
        System.out.println("adicionarContaPF");
        AbrirContaPF conta = null;
        AbrirContaPF instance = new AbrirContaPF();
        instance.adicionarContaPF(conta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criarListaContasPF method, of class AbrirContaPF.
     */
    @Test
    public void testCriarListaContasPF() {
        System.out.println("criarListaContasPF");
        AbrirContaPF instance = new AbrirContaPF();
        List<ContaPF> expResult = null;
        List<ContaPF> result = instance.criarListaContasPF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
