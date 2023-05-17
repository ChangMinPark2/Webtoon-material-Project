package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import project.nftshop.persistence.BaseEntity;

import javax.persistence.*;

@Getter
@Table(name = "tbl_user_product")
@Entity
@NoArgsConstructor
@AttributeOverride(
        name = "id",
        column = @Column(name = "user_product_id")
)
public class UserProduct extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Builder
    public UserProduct(User user,
                       Product product) {
        this.user = user;
        this.product = product;
    }
}
