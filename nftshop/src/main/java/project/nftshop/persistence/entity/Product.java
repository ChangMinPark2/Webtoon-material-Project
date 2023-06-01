package project.nftshop.persistence.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.nftshop.persistence.BaseEntity;
import project.nftshop.service.model.request.ProductReqDtos;

import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

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
    private String productsNames;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private int price;

    @Column(name = "quantity_sale")
    private int quantitySale;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "image_file_id")
    private ImageFile imageFile;

    @Builder
    public Product(String productsNames,
                   String description,
                   int price,
                   int quantitySale,
                   ImageFile imageFile,
                   User user) {
        this.productsNames = productsNames;
        this.description = description;
        this.price = price;
        this.quantitySale = quantitySale;
        this.imageFile = imageFile;
        this.user = user;
    }

//    public void updateUserProduct(List<UserProduct> userProducts){
//        this.userProducts = userProducts;
//    }

    /**
     * createOrder -> 판매수량 증가
     * 랭킹을 위해 필요
     * */
    public void incrementQuantitySale(){
        int newQuantity = this.getQuantitySale() + 1;
        this.quantitySale = newQuantity;
    }

    public void updateProduct(ProductReqDtos.UPDATE update){
        this.productsNames = update.getProductsNames();
        this.description = update.getDescription();
        this.price = update.getPrice();
    }
}
