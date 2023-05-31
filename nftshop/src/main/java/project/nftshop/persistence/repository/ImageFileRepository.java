package project.nftshop.persistence.repository;

import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.ImageFile;

import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

    Optional<ImageFile> findBySaveName(String saveName);


//    Optional<ImageFile> findByProduct_ProductsNames(String productName);

//    @Query("SELECT p.imageFile.saveName FROM Product p WHERE p.productsNames = :productsNames")
//    Optional<ImageFile> findImageFileByProductName(@Param("productsNames") String productsNames);

}
