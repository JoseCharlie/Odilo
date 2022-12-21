package odilo.recruitment.firmaJuridica.persistence.repositories;


import odilo.recruitment.firmaJuridica.persistence.entities.Certificado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {

    Certificado findByUserId(Long userId);

    List<Certificado> findAll();
}
