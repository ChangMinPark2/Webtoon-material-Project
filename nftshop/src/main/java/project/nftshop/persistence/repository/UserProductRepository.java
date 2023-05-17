package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import project.nftshop.persistence.entity.UserProduct;

import java.util.List;

public interface UserProductRepository extends JpaRepository<UserProduct, Long> {

    @Query("SELECT up.product.productsNames FROM UserProduct up WHERE up.user.identity = :identity")
    List<String> findProductNamesByUserIdentity(@Param("identity") String identity);
}
