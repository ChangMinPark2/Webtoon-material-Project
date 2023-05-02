package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.User;
import project.nftshop.service.model.Gender;
import project.nftshop.service.model.request.UserReqDtos;
import project.nftshop.service.model.response.UserResDtos;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(source = "create.identity", target = "identity")
    @Mapping(source = "create.password", target = "password")
    @Mapping(source = "create.birth", target = "birth")
    @Mapping(source = "create.name", target = "name")
    @Mapping(source = "create.cellphone", target = "cellphone")
    @Mapping(source = "create.email", target = "email")
    @Mapping(source = "create.gender", target = "gender")
    User toUserEntity(UserReqDtos.CREATE create);

    @Mapping(source = "user.identity", target = "identity")
    @Mapping(source = "user.birth", target = "birth")
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.cellphone", target = "cellphone")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.gender", target = "gender")
    UserResDtos.READ toReadDto(User user);
}
