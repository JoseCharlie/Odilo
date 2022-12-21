package odilo.recruitment.firmaJuridica.service;

import lombok.AllArgsConstructor;
import odilo.recruitment.firmaJuridica.persistence.entities.Usuario;
import odilo.recruitment.firmaJuridica.persistence.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Usuario findByUserId(Long userId) {
        return usuarioRepository.findByUserId(userId);
    }

    public Usuario findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    public void store(String username) throws IOException {
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuarioRepository.save(usuario);
    }

}
