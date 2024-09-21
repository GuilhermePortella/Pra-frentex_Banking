package br.prafrentex_service.RegisterUser;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 *
 * @author Guilherme
 */
public class UsuarioServiceRegister {

    //private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void registrarUsuario(String nome, String email, String senha) {
        //String senhaHash = passwordEncoder.encode(senha);

        // Criar o usuário e salvar no banco de dados com a senha criptografada
        //Usuario usuario = new Usuario(nome, email, senhaHash);
        // Associe o usuário a uma conta PF ou PJ
    }

}
