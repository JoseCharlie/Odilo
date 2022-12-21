package odilo.recruitment.firmaJuridica.controller;

import lombok.RequiredArgsConstructor;
import odilo.recruitment.firmaJuridica.persistence.entities.Certificado;
import odilo.recruitment.firmaJuridica.persistence.entities.Usuario;
import odilo.recruitment.firmaJuridica.security.InterfaceAuthentication;
import odilo.recruitment.firmaJuridica.service.CertificadoService;
import odilo.recruitment.firmaJuridica.service.UsuarioService;
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

    @Autowired
    private InterfaceAuthentication authenticationFacade;

    /**
     * Método POST para firmar un certificado con una firma pasada en parámetro
     * @param firma
     * @return el certificado firmado
     * @throws IOException
     */
    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> firmar(@RequestParam("firma") String firma) throws IOException {
        Authentication authentication = authenticationFacade.getAuthentication();
        Usuario usuario = serviceUsuario.findByUsername(authentication.getName());
        Certificado certificado = serviceFirma.findByUser(usuario.getUserId());
        return new ResponseEntity<>("#"+firma+"#"+certificado.getCertificado(),HttpStatus.OK);
    }



}
