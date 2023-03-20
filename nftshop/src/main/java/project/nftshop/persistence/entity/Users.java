package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id", length = 4)
    private Long id;

    @Column(name = "identity", unique = true, length = 30)
    private String identity;

    @Column(name = "password")
    private String password;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "cellphone", unique = true, length = 30)
    private String cellphone;

    @Column(name = "email")
    private String email;

    @Builder
    public Users(String identity,
                 String password,
                 String name,
                 String cellphone,
                 String email) {
        this.identity = identity;
        this.password = password;
        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
    }
}
