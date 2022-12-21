package odilo.recruitment.firmaJuridica.persistence.repositories;

import odilo.recruitment.firmaJuridica.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByUserId(Long userId);

    Usuario findByUsername(String username);

    List<Usuario> findAll();


}
