package project.nftshop.service.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.User;
import project.nftshop.service.model.PaymentType;
import project.nftshop.service.model.request.OrderReqDtos;
import project.nftshop.service.model.response.OrderResDtos;

import java.time.LocalDate;
import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(source = "create.paymentType", target = "paymentTypes")
    @Mapping(source = "paymentDate", target = "paymentDate")
    @Mapping(source = "user",target = "users")
    @Mapping(source = "orderProducts", target = "orderProducts")
    @Mapping(source = "totalPrice", target = "totalPrice")
    Order toOrderEntity(OrderReqDtos.CREATE create,
                        User user,
                        LocalDate paymentDate,
                        List<OrderProduct> orderProducts,
                        int totalPrice);

    @Mapping(target = "totalPrice", source = "order.totalPrice")
    @Mapping(target = "paymentDate", source = "order.paymentDate")
    @Mapping(target = "paymentType", source = "order.paymentTypes")
    @Mapping(target = "productsName", source = "productsNames")
    OrderResDtos.READ toReadDto(Order order,List<String> productsNames);
}
