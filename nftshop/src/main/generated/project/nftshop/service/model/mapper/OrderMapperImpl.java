package project.nftshop.service.model.mapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.User;
import project.nftshop.service.model.PaymentType;
import project.nftshop.service.model.request.OrderReqDtos;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-03T20:45:40+0900",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.18 (Azul Systems, Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public Order toOrderEntity(OrderReqDtos.CREATE create, User user, LocalDate paymentDate, List<OrderProduct> orderProducts) {
        if ( create == null && user == null && paymentDate == null && orderProducts == null ) {
            return null;
        }

        Order.OrderBuilder order = Order.builder();

        if ( create != null ) {
            if ( create.getPaymentType() != null ) {
                order.paymentTypes( Enum.valueOf( PaymentType.class, create.getPaymentType() ) );
            }
        }
        order.users( user );
        order.paymentDate( paymentDate );
        List<OrderProduct> list = orderProducts;
        if ( list != null ) {
            order.orderProducts( new ArrayList<OrderProduct>( list ) );
        }

        return order.build();
    }
}
