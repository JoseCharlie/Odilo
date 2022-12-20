package odilo.recruitment.firmaJuridica.persistence;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Certificado {

    @Id
    @GeneratedValue
    private Long id;
    private Long userId;
    private String certificate;

    public Certificado(){}

    public Certificado(Long userId, String certificate) {
        this.userId = userId;
        this.certificate = certificate;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    @Override
    public String toString() {
        return "Certificado{" +
                "id=" + id +
                ", userId=" + userId +
                ", certificate='" + certificate + '\'' +
                '}';
    }
}
