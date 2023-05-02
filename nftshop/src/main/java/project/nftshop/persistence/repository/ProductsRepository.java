package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.Product;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);

    @Query("select p from Product p where p.name in:productsNames")
    List<Product> findAllByProductsName(@Param("productsNames") Set<String> productsNames);
}
