package br.prafrentex_service.loginUser;

import br.prafrentex_domain.Usuario;
import br.prafrentex_service.RegisterUserSimples.CadastroUsuarioService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    // @InjectMocks
    // private AuthService authService;

    // @Mock
    // private CadastroUsuarioService cadastroUsuarioService;

    // @BeforeAll
    // public void setUp() {
    //     MockitoAnnotations.openMocks(this); // Use 'this' instead of the class
    // }

    // @Test
    // public void testAdicionarContaPF() {
    //     Usuario usuario = new Usuario();
    //     usuario.setNome("João");
    //     usuario.setSobrenome("Silva");
    //     usuario.setCpf("123.456.789-00");
    //     String agencia = "1234";
    //     String conta = "567890";

    //     authService.adicionarContaPF(usuario, agencia, conta);

    //     List<Usuario> contasPF = authService.criarListaContasPF();
    //     assertEquals(1, contasPF.size());
    //     assertEquals("João", contasPF.get(0).getNome());
    //     assertEquals("1234", contasPF.get(0).getAgencia());
    //     assertEquals("567890", contasPF.get(0).getConta());
    // }

    // @Test
    // public void testCadastrarUsuario() {
    //     when(cadastroUsuarioService.gerarAgencia()).thenReturn("1234");
    //     when(cadastroUsuarioService.gerarConta()).thenReturn("567890");

    //     System.setIn(new java.io.ByteArrayInputStream(
    //             ("João\nSilva\n2000-01-01\njoao@email.com\n123.456.789-00\nsenha123\n").getBytes()));

    //     authService.cadastrarUsuario();

    //     List<Usuario> contasPF = authService.criarListaContasPF();
    //     assertEquals(1, contasPF.size());
    //     Usuario usuario = contasPF.get(0);
    //     assertEquals("João", usuario.getNome());
    //     assertEquals("Silva", usuario.getSobrenome());
    //     assertEquals("1234", usuario.getAgencia());
    //     assertEquals("567890", usuario.getConta());
    // }

    // @Test
    // public void testExibirDadosUsuarios() {
    //     Usuario usuario = new Usuario();
    //     usuario.setNome("João");
    //     usuario.setSobrenome("Silva");
    //     usuario.setCpf("123.456.789-00");
    //     usuario.setAgencia("1234");
    //     usuario.setConta("567890");
    //     authService.adicionarContaPF(usuario, "1234", "567890");

    //     authService.exibirDadosUsuarios();

    //     assertNotNull(usuario);

    // }
}
