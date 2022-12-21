package odilo.recruitment.firmaJuridica.controller;

import lombok.RequiredArgsConstructor;
import odilo.recruitment.firmaJuridica.FirmaJuridicaApplication;
import odilo.recruitment.firmaJuridica.persistence.entities.Certificado;
import odilo.recruitment.firmaJuridica.persistence.entities.Usuario;
import odilo.recruitment.firmaJuridica.security.InterfaceAuthentication;
import odilo.recruitment.firmaJuridica.service.CertificadoService;
import odilo.recruitment.firmaJuridica.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/firma")
@RequiredArgsConstructor
public class FirmaController {

    private final CertificadoService serviceFirma;
    private final UsuarioService serviceUsuario;
    private static final Logger log = LoggerFactory.getLogger(FirmaJuridicaApplication.class);

    @Autowired
    private InterfaceAuthentication authenticationFacade;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> firmar(@RequestParam("firma") String firma) throws IOException {
        Authentication authentication = authenticationFacade.getAuthentication();
        Usuario usuario = serviceUsuario.findByUsername(authentication.getName());
        Certificado certificado = serviceFirma.findByUser(usuario.getUserId());
        return new ResponseEntity<>("#"+firma+"#"+certificado.getCertificado(),HttpStatus.OK);
    }



}
