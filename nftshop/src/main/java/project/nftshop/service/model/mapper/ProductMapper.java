package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import project.nftshop.persistence.entity.ImageFile;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.entity.User;
import project.nftshop.persistence.entity.UserProduct;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "create.productsNames", target = "productsNames")
    @Mapping(source = "create.price", target = "price")
    @Mapping(source = "create.description", target = "description")
    @Mapping(source = "imageFile", target = "imageFile")
    Product toProductEntity(ProductReqDtos.CREATE create, ImageFile imageFile);

    @Mapping(source = "product.productsNames", target = "productsNames")
    @Mapping(source = "product.price", target = "price")
    @Mapping(source = "product.description", target = "description")
    ProductResDtos.READ toReadDto(Product product);
}
