package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.repository.ProductRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    /**
     * 상품 등록
     */
    @Transactional
    public void saveProduct(Product product){
        productRepository.save(product);
    }

    /**
     * 상품 수정
     */
    @Transactional
    public void updateProduct(Long id, String name, String description, int price, int quantitySale){
        Product product = productRepository.findOne(id);
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantitySale(quantitySale);
    }


    public List<Product> findProducts(){
        return productRepository.findAll();
    }

    public Product findOne(Long id){
        return productRepository.findOne(id);
    }
}
