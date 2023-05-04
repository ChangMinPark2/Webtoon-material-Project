package project.nftshop.service.model.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.Product;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T20:45:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class OrderProductMapperImpl implements OrderProductMapper {

    @Override
    public OrderProduct toOrderProductEntity(Product product, Order order) {
        if ( product == null && order == null ) {
            return null;
        }

        OrderProduct.OrderProductBuilder orderProduct = OrderProduct.builder();

        orderProduct.product( product );
        orderProduct.order( order );

        return orderProduct.build();
    }
}
