package br.prafrentex_service.RegisterUser;

import br.prafrentex_domain.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;
import javax.transaction.Transactional;

/**
 *
 * @author Guilherme
 */
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Usuario salvar(Usuario usuario) {
        entityManager.persist(usuario);
        return usuario;
    }

    public Optional<Usuario> findByEmail(String email) {
        try {
            Usuario usuario = entityManager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email", Usuario.class)
                    .setParameter("email", email)
                    .getSingleResult();
            return Optional.of(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
