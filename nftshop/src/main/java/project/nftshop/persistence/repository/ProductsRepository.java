package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.Product;

import java.util.Optional;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {

    Optional<Product> findByName(String name);
}
