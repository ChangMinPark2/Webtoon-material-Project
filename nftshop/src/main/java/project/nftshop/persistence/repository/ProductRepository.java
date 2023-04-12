package project.nftshop.persistence.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import project.nftshop.persistence.entity.Product;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepository {
    private final EntityManager em;

    public void save(Product product){
        if(product.getId() == null){
            em.persist(product);
        } else {
            em.merge(product);
        }
    }

    public void delete(Long id){
        em.createQuery("delete from Product p where p.id = ?1", Product.class)
                .setParameter(1, id);
    }

    public Product findOne(Long id){
        return em.find(Product.class, id);
    }

    public List<Product> findAll(){
        return em.createQuery("select p from Product p", Product.class)
                .getResultList();
    }

}
