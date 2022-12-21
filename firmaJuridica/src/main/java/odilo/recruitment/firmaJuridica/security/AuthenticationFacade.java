package odilo.recruitment.firmaJuridica.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade implements InterfaceAuthentication {

    /**
     * Método para obtener la autenticación actual del contexto
     * @return
     */
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
