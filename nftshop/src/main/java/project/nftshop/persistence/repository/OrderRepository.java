package project.nftshop.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.Order;
import project.nftshop.persistence.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query("select o from Order o where o.user.identity =:identity")
    List<Order> findByUsersIdentity(@Param("identity") String identity);

    List<Order> findByUser(User user);
}
