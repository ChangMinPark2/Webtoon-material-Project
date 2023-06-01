package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;
import project.nftshop.service.model.PaymentType;
import project.nftshop.service.model.request.OrderReqDtos;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            mappedBy = "order"
    )
    private List<OrderProduct> orderProducts = new ArrayList<>();

    @Builder
    public Order(PaymentType paymentTypes,
                 int totalPrice,
                 LocalDate paymentDate,
                 User users,
                 List<OrderProduct> orderProducts) {
        this.paymentTypes = paymentTypes;
        this.totalPrice = totalPrice;
        this.paymentDate = paymentDate;
        this.users = users;
        this.orderProducts = orderProducts;
    }

    public void updateOrderProducts(List<OrderProduct> orderProducts){
        this.orderProducts = orderProducts;
    }

    public void updateTotalPrice(int totalPrice){
        this.totalPrice = totalPrice;
    }
}
