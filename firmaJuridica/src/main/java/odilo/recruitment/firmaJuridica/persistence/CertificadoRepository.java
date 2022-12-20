package odilo.recruitment.firmaJuridica.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CertificadoRepository extends CrudRepository {

    Certificado findById(Long id);

    Certificado findByUserId(Long userId);

    List<Certificado> findAll();
}
