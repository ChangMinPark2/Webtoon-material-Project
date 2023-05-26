package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.ImageFile;

import java.util.Optional;

@Repository
public interface ImageFileRepository extends JpaRepository<ImageFile, Long> {

    Optional<ImageFile> findBySaveName(String saveName);
}
