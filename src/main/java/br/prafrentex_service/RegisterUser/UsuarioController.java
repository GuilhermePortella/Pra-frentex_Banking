package br.prafrentex_service.RegisterUser;

import br.prafrentex_domain.Usuario;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Guilherme
 */
@Path("/usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioController {

    @Inject
    private UsuarioService usuarioService;

    @POST
    @Path("/registrar")
    public Response registrarUsuario(@Valid UsuarioDTO usuarioDTO) {
        try {
            Usuario novoUsuario = usuarioService.registrarUsuario(usuarioDTO);
            return Response.status(Response.Status.CREATED).entity(novoUsuario).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(e.getMessage()))
                    .build();
        }
    }

    @POST
    @Path("/login")
    public Response autenticarUsuario(Credenciais credenciais) {
        try {
            boolean autenticado = usuarioService.autenticarUsuario(credenciais.getEmail(), credenciais.getSenha());
            if (autenticado) {
                // Aqui você pode gerar e retornar um token JWT ou outro mecanismo de sessão
                return Response.ok(new SuccessMessage("Autenticação bem-sucedida")).build();
            } else {
                return Response.status(Response.Status.UNAUTHORIZED)
                        .entity(new ErrorMessage("Credenciais inválidas"))
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new ErrorMessage(e.getMessage()))
                    .build();
        }
    }
}
