package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.OrderProduct;
import project.nftshop.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

    Optional<OrderProduct> findByProduct_ProductsNames(String name);

    List<OrderProduct> findByProduct(Product product);
}
