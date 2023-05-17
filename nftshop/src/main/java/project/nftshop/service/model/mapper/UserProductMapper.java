package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.*;

@Mapper(componentModel = "spring")
public interface UserProductMapper {

    @Mapping(source = "user", target = "user")
    @Mapping(source = "product", target = "product")
    UserProduct toOrderProductEntity(User user, Product product);
}
