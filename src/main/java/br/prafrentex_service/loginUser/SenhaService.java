package br.prafrentex_service.loginUser;

import java.security.SecureRandom;
import java.util.Base64;

/**
 *
 * @author Guilherme
 */
public class SenhaService {
    private static final SecureRandom random = new SecureRandom();

    public static String gerarHashSenha(String senha) { 
        return Base64.getEncoder().encodeToString((senha + "SALT").getBytes());
    }

    public boolean verificarSenha(String senha, String senhaHash) {
        return senhaHash.equals(gerarHashSenha(senha));
    }
}
