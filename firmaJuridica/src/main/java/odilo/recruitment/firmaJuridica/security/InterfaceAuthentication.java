package odilo.recruitment.firmaJuridica.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

public interface InterfaceAuthentication {
    Authentication getAuthentication();
}
