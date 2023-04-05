package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;
import project.nftshop.service.model.Gender;
import project.nftshop.service.model.request.CreateUserDto;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_user")
@AttributeOverride(
        name = "id",
        column = @Column(name = "user_id", length = 4)
)

public class User extends BaseEntity {

    @Column(name = "identity", unique = true, length = 30)
    private String identity;

    @Column(name = "password")
    private String password;

    @Column(name = "birth")
    private String birth;

    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "cellphone", unique = true, length = 30)
    private String cellphone;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    private Gender gender;

    @Builder
    public User(String identity,
                String password,
                String birth,
                String name,
                String cellphone,
                String email,
                Gender gender) {
        this.identity = identity;
        this.password = password;
        this.birth =  birth;
        this.name = name;
        this.cellphone = cellphone;
        this.email = email;
        this.gender = gender;
    }

    public static User createOf(CreateUserDto createUserDto){
        return User.builder()
                .identity(createUserDto.getIdentity())
                .password(createUserDto.getPassword())
                .birth(createUserDto.getBirth())
                .name(createUserDto.getName())
                .cellphone(createUserDto.getCellphone())
                .email(createUserDto.getEmail())
                .gender(Gender.valueOf(createUserDto.getGender()))
                .build();
    }
}
