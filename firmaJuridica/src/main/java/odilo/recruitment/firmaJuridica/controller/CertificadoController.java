package odilo.recruitment.firmaJuridica.controller;

import lombok.RequiredArgsConstructor;
import odilo.recruitment.firmaJuridica.FirmaJuridicaApplication;
import odilo.recruitment.firmaJuridica.persistence.entities.Usuario;
import odilo.recruitment.firmaJuridica.security.InterfaceAuthentication;
import odilo.recruitment.firmaJuridica.service.CertificadoService;
import odilo.recruitment.firmaJuridica.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/certificado")
@RequiredArgsConstructor
public class CertificadoController {

    private final CertificadoService serviceCertificado;
    private final UsuarioService serviceUsuario;

    @Autowired
    private InterfaceAuthentication authenticationFacade;

    /**
     * Método POST para cubir un nuevo certificado a la base
     * @param certificado
     * @return mensaje de éxito
     * @throws IOException
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public String subirCertificado(@RequestParam("certificado") MultipartFile certificado) throws IOException {

        Authentication authentication = authenticationFacade.getAuthentication();
        Usuario user = serviceUsuario.findByUsername(authentication.getName());
        serviceCertificado.store(user.getUserId(), certificado.getInputStream().toString());

        return "Certificado actualizado con éxito";
    }
}
