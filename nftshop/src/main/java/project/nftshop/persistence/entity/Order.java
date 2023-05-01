package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;
import project.nftshop.service.model.PaymentType;
import project.nftshop.service.model.request.OrderReqDtos;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "tbl_order")
@AttributeOverride(
        name = "id",
        column = @Column(name = "order_id")
)
public class Order extends BaseEntity {

    @Column(name = "payment_type")
    private PaymentType paymentTypes;

    @Column(name = "total_price")
    private int totalPrice;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product products;

    @Builder
    public Order(PaymentType paymentTypes,
                 int totalPrice,
                 LocalDate paymentDate,
                 User users,
                 Product products) {
        this.paymentTypes = paymentTypes;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
        this.users = users;
        this.products = products;
    }

    public static Order toOrderCreate(OrderReqDtos.CREATE create,
                           User user,
                           LocalDate paymentDate,
                           Product product){

        return Order.builder()
                .paymentTypes(PaymentType.of(create.getPaymentType()))
                .paymentDate(paymentDate)
                .products(product)
                .users(user)
                .build();
    }

}
