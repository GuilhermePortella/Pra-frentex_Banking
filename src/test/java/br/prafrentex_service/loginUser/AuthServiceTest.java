package br.prafrentex_service.loginUser;

import br.domain.model.usuarios.Usuario;
import br.service.RegisterUserSimples.CadastroUsuarioService;
import br.service.loginUser.AuthService;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;



@TestInstance(Lifecycle.PER_CLASS)
public class AuthServiceTest {

    @InjectMocks
    private AuthService authService;

    @Mock
    private CadastroUsuarioService cadastroUsuarioService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdicionarContaPF() {
        Usuario usuario = new Usuario();
        String agencia = "0001";
        String conta = "12345-6";

        authService.adicionarContaPF(usuario, agencia, conta);

        List<Usuario> contas = authService.criarListaContasPF();
        assertFalse(contas.isEmpty());
        assertEquals(1, contas.size());
        assertEquals(agencia, contas.get(0).getAgencia());
        assertEquals(conta, contas.get(0).getConta());
    }

    @Test
    public void testCriarListaContasPFVazia() {
        List<Usuario> contas = authService.criarListaContasPF();
        assertNotNull(contas);
    }

    @Test
    public void testCadastrarUsuario() {
        when(cadastroUsuarioService.gerarAgencia()).thenReturn("0001");
        when(cadastroUsuarioService.gerarConta()).thenReturn("12345-6");

        Usuario usuario = new Usuario();
        usuario.setNome("Test");
        usuario.setCpf("123.456.789-00");

        authService.adicionarContaPF(usuario, "0001", "12345-6");

        List<Usuario> contas = authService.criarListaContasPF();
        assertFalse(contas.isEmpty());
        assertEquals("0001", contas.get(0).getAgencia());
        assertEquals("12345-6", contas.get(0).getConta());
    }
}
