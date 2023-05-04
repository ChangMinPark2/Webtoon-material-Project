package project.nftshop.service.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.nftshop.persistence.entity.Product;
import project.nftshop.service.model.request.ProductReqDtos;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T20:45:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProductEntity(ProductReqDtos.CREATE create) {
        if ( create == null ) {
            return null;
        }

        Product.ProductBuilder product = Product.builder();

        product.name( create.getName() );
        product.price( create.getPrice() );
        product.description( create.getDescription() );
        product.quantitySale( create.getQuantitySale() );

        return product.build();
    }
}
