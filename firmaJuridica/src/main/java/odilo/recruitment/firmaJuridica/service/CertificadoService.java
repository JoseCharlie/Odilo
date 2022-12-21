package odilo.recruitment.firmaJuridica.service;

import lombok.AllArgsConstructor;
import odilo.recruitment.firmaJuridica.persistence.entities.Certificado;
import odilo.recruitment.firmaJuridica.persistence.repositories.CertificadoRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class CertificadoService {

    private final CertificadoRepository certificadoRepository;


    public Certificado findByUser(Long userId) {
    return certificadoRepository.findByUserId(userId);
    }

    public void store(Long userId, String certificado) {
        Certificado certificate = certificadoRepository.findByUserId(userId);
        if (certificate == null) {
            certificate = new Certificado();
        }
        certificate.setUserId(userId);
        certificate.setCertificado(certificado);
        certificadoRepository.save(certificate);
    }
}
