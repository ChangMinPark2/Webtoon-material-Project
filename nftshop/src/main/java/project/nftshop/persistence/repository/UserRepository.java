package project.nftshop.persistence.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Optional<User> findByIdentity(String identity);

    boolean existsByCellphone(String cellphone);

    boolean existsByIdentity(String identity);
}
