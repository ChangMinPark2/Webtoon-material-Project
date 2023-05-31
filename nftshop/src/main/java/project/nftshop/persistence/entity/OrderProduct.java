package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_order_product")
@Getter
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "order_product_id")
)
public class OrderProduct extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public OrderProduct(Order order,
                        Product product){
        this.order = order;
        this.product = product;
    }
}
