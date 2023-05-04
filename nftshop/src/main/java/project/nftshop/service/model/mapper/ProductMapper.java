package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.Product;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "create.productsNames", target = "productsNames")
    @Mapping(source = "create.price", target = "price")
    @Mapping(source = "create.description", target = "description")
    Product toProductEntity(ProductReqDtos.CREATE create);

    @Mapping(source = "product.productsNames", target = "productsNames")
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.description", target = "description")
    ProductResDtos.READ toReadDto(Product product);
}
