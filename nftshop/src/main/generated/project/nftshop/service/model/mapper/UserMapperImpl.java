package project.nftshop.service.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.nftshop.persistence.entity.User;
import project.nftshop.service.model.Gender;
import project.nftshop.service.model.request.UserReqDtos;
import project.nftshop.service.model.response.UserResDtos;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T20:45:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUserEntity(UserReqDtos.CREATE create) {
        if ( create == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.identity( create.getIdentity() );
        user.password( create.getPassword() );
        user.birth( create.getBirth() );
        user.name( create.getName() );
        user.cellphone( create.getCellphone() );
        user.email( create.getEmail() );
        if ( create.getGender() != null ) {
            user.gender( Enum.valueOf( Gender.class, create.getGender() ) );
        }

        return user.build();
    }

    @Override
    public UserResDtos.READ toReadDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserResDtos.READ.READBuilder rEAD = UserResDtos.READ.builder();

        rEAD.identity( user.getIdentity() );
        rEAD.birth( user.getBirth() );
        rEAD.name( user.getName() );
        rEAD.cellphone( user.getCellphone() );
        rEAD.email( user.getEmail() );
        rEAD.gender( user.getGender() );

        return rEAD.build();
    }
}
