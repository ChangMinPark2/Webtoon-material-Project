package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.User;
import project.nftshop.service.model.PaymentType;
import project.nftshop.service.model.request.OrderReqDtos;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "create.paymentType", target = "paymentTypes")
    @Mapping(source = "paymentDate", target = "paymentDate")
    @Mapping(source = "user",target = "users")
    @Mapping(source = "orderProducts", target = "orderProducts")
    Order toOrderEntity(OrderReqDtos.CREATE create,
                        User user,
                        LocalDate paymentDate,
                        List<OrderProduct> orderProducts);
}
