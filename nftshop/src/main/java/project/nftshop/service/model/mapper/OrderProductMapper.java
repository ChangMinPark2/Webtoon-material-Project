package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.Product;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {

    @Mapping(source = "product", target = "product")
    @Mapping(source = "order", target = "order")
    OrderProduct toOrderProductEntity(Product product, Order order);
}
