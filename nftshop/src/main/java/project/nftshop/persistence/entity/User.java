package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;
import project.nftshop.service.model.Gender;
import project.nftshop.service.model.request.UserReqDtos;
import project.nftshop.service.model.response.UserResDtos;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @Enumerated(EnumType.STRING)
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

    /**
     * Mapper 사용
     * */
    public static User toUserCreate(UserReqDtos.CREATE create){
        return User.builder()
                .identity(create.getIdentity())
                .password(create.getPassword())
                .birth(create.getBirth())
                .name(create.getName())
                .cellphone(create.getCellphone())
                .email(create.getEmail())
                .gender(Gender.of(create.getGender()))
                .build();
    }

    public static UserResDtos.READ readToEntity(User user){
        return UserResDtos.READ.builder()
                .identity(user.getIdentity())
                .birth(user.getBirth())
                .name(user.getName())
                .cellphone(user.getCellphone())
                .email(user.getEmail())
                .gender(user.getGender())
                .build();
    }

    public void updatePassword(UserReqDtos.PASSWORDUPDATE passwordUpdate){
        this.password = passwordUpdate.getNewPassword();
    }

    public void updateUser(UserReqDtos.UPDATE update){
        this.birth = update.getBirth();
        this.name = update.getName();
        this.cellphone = update.getCellphone();
        this.email = update.getEmail();
        this.gender = Gender.of(update.getGender());
    }

}
