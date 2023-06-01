package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.entity.User;
import project.nftshop.persistence.entity.UserProduct;

import java.util.List;
import java.util.Optional;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    @Query("SELECT up.product FROM UserProduct up WHERE up.user.identity = :identity")
    List<Product> findProductByUserIdentity(@Param("identity") String identity);

    Optional<UserProduct> findByProduct_ProductsNames(String name);

    List<UserProduct> findProductByUser(User user);
}
