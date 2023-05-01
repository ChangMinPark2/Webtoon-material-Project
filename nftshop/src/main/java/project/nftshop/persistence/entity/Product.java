package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.nftshop.persistence.BaseEntity;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "tbl_product")
@Entity
@AttributeOverride(
        name = "id",
        column = @Column(name = "product_id", length = 4)
)

public class Product extends BaseEntity {

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity_sale")
    private int quantitySale;

    @Builder
    public Product(String name,
                   String description,
                   int price,
                   int quantitySale) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantitySale = quantitySale;
    }

    /**
     * createOrder -> 판매수량 증가
     * 랭킹을 위해 필요
     * */
    public void incrementQuantitySale(){
        int newQuantity = this.getQuantitySale() + 1;
        this.quantitySale = newQuantity;
    }
}
