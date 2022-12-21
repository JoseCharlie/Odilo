package odilo.recruitment.firmaJuridica.persistence.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name = "username")
    private String username;

    @Override
    public String toString() {
        return "Usuario{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}



