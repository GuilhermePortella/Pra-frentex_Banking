package br.prafrentex_service.RegisterUser;

import org.mindrot.jbcrypt.BCrypt;
import br.prafrentex_domain.Usuario;
import java.util.Optional;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 *
 * @author Guilherme
 */
@RequestScoped
public class UsuarioService {

    @Inject
    private UsuarioDAO usuarioDAO;

    public Usuario registrarUsuario(String nome, String email, String senha) {

        if (usuarioDAO.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email já registrado.");
        }

        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());

        Usuario usuario = new Usuario(nome, email, senhaHash);

        return usuarioDAO.salvar(usuario);
    }

    public boolean autenticarUsuario(String email, String senha) {
        Optional<Usuario> usuarioOpt = usuarioDAO.findByEmail(email);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            return BCrypt.checkpw(senha, usuario.getSenhaHash());
        }
        return false;
    }

    Usuario registrarUsuario(UsuarioDTO usuarioDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}