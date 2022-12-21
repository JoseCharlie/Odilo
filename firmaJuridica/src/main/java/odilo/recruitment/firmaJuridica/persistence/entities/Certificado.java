package odilo.recruitment.firmaJuridica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "certificado")
public class Certificado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "userID")
    private Long userId;
    @Column(name = "certificado")
    private String certificado;

    @Override
    public String toString() {
        return "Certificado{" +
                "id=" + id +
                ", userId=" + userId +
                ", certificate='" + certificado + '\'' +
                '}';
    }
}
