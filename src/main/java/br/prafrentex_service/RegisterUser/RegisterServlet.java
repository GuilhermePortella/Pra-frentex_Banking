package br.prafrentex_service.RegisterUser;

import br.prafrentex_domain.Usuario;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guilherme
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Inject
    private UsuarioService usuarioService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try {
            Usuario usuario = usuarioService.registrarUsuario(nome, email, senha);
            response.getWriter().write("Usuário registrado com sucesso: " + usuario.getNome());
        } catch (IllegalArgumentException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write(e.getMessage());
        }
    }
}
