/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.prafrentex_service;

import br.prafrentex_domain.ContaPJ;
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
public class AbrirContaPJIT {
    
    public AbrirContaPJIT() {
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
     * Test of validarCNPJ method, of class AbrirContaPJ.
     */
    @Test
    public void testValidarCNPJ() {
        System.out.println("validarCNPJ");
        AbrirContaPJ instance = new AbrirContaPJ();
        boolean expResult = false;
        boolean result = instance.validarCNPJ();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarCNPJValido method, of class AbrirContaPJ.
     */
    @Test
    public void testSolicitarCNPJValido() {
        System.out.println("solicitarCNPJValido");
        AbrirContaPJ instance = new AbrirContaPJ();
        instance.solicitarCNPJValido();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solicitarDadosEmpresa method, of class AbrirContaPJ.
     */
    @Test
    public void testSolicitarDadosEmpresa() {
        System.out.println("solicitarDadosEmpresa");
        AbrirContaPJ instance = new AbrirContaPJ();
        instance.solicitarDadosEmpresa();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of apresentarDadosEmLista method, of class AbrirContaPJ.
     */
    @Test
    public void testApresentarDadosEmLista() {
        System.out.println("apresentarDadosEmLista");
        AbrirContaPJ instance = new AbrirContaPJ();
        ContaPJ expResult = null;
        ContaPJ result = instance.apresentarDadosEmLista();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
