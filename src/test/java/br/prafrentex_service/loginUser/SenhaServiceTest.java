package br.prafrentex_service.loginUser;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.service.loginUser.SenhaService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SenhaServiceTest {

    @Test
    public void testGerarHashSenha() {
        // Arrange
        String senha = "senha123";

        // Act
        String hash = SenhaService.gerarHashSenha(senha);

        // Assert
        assertNotNull(hash);
        assertFalse(hash.isEmpty());
        assertNotEquals(senha, hash); // O hash deve ser diferente da senha original
    }

    @Test
    public void testVerificarSenhaCorreta() {
        // Arrange
        String senha = "senha123";
        String hash = SenhaService.gerarHashSenha(senha);

        // Act
        boolean resultado = new SenhaService().verificarSenha(senha, hash);

        // Assert
        assertTrue(resultado); // A senha deve ser validada corretamente
    }

    @Test
    public void testVerificarSenhaIncorreta() {
        // Arrange
        String senha = "senha123";
        String senhaErrada = "senhaErrada";
        String hash = SenhaService.gerarHashSenha(senha);

        // Act
        boolean resultado = new SenhaService().verificarSenha(senhaErrada, hash);

        // Assert
        assertFalse(resultado); // A senha incorreta não deve ser validada
    }

    @Test
    public void testGerarHashSenhaConsistente() {
        // Arrange
        String senha = "senha123";

        // Act
        String hash1 = SenhaService.gerarHashSenha(senha);
        String hash2 = SenhaService.gerarHashSenha(senha);

        // Assert
        assertEquals(hash1, hash2); // O hash deve ser consistente para a mesma senha
    }
}
