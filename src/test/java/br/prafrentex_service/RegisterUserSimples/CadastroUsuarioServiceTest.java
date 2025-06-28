package br.prafrentex_service.RegisterUserSimples;

import br.prafrentex_domain.usuarios.Usuario;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.List;



public class CadastroUsuarioServiceTest {

    private CadastroUsuarioService cadastroUsuarioService;

    // @BeforeAll
    // public void setUp() {
    //     cadastroUsuarioService = new CadastroUsuarioService();
    // }

    // @Test
    // public void testGerarAgencia() {
    //     String agencia = cadastroUsuarioService.gerarAgencia();

    //     assertNotNull(agencia);
    //     assertEquals(4, agencia.length()); // Deve ter 4 dígitos
    //     assertTrue(agencia.matches("\\d{4}")); // Deve conter apenas números
    // }

    // @Test
    // public void testGerarConta() {
    //     String conta = cadastroUsuarioService.gerarConta();

    //     assertNotNull(conta);
    //     assertEquals(9, conta.length()); // Deve ter 9 dígitos
    //     assertTrue(conta.matches("\\d{9}")); // Deve conter apenas números
    // }

    // @Test
    // public void testAdicionarContaPF() {
    //     Usuario usuario = new Usuario();
    //     usuario.setNome("João");
    //     usuario.setSobrenome("Silva");
    //     usuario.setCpf("123.456.789-00");
    //     String agencia = "1234";
    //     String conta = "567890";

    //     cadastroUsuarioService.cadastrarUsuario();
    //     List<Usuario> contasPF = cadastroUsuarioService.criarListaContasPF();

    //     assertNotNull(contasPF);
    //     assertFalse(contasPF.isEmpty());
    // }

    // @Test
    // public void testCriarListaContasPF() {
    //     Usuario usuario = new Usuario();
    //     usuario.setNome("João");
    //     usuario.setSobrenome("Silva");
    //     usuario.setCpf("123.456.789-00");
    //     cadastroUsuarioService.cadastrarUsuario();

    //     List<Usuario> contasPF = cadastroUsuarioService.criarListaContasPF();

    //     assertNotNull(contasPF);
    //     assertFalse(contasPF.isEmpty());
    //     assertEquals(1, contasPF.size());
    // }

    // @Test
    // public void testExibirDadosUsuarios() {

    //     Usuario usuario = new Usuario();
    //     usuario.setNome("João");
    //     usuario.setSobrenome("Silva");
    //     usuario.setCpf("123.456.789-00");
    //     cadastroUsuarioService.cadastrarUsuario();

    //     cadastroUsuarioService.exibirDadosUsuarios();

    //     assertNotNull(usuario);

    // }
}
