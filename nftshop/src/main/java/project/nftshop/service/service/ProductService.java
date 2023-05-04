package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.nftshop.infra.error.exception.DuplicatedProductNameException;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.service.model.mapper.ProductMapper;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Transactional
    public void createProduct(ProductReqDtos.CREATE create){

        final Product product = productMapper.toProductEntity(create);

        checkProductsNames(create.getProductsNames());

        productRepository.save(product);
    }

    public ProductResDtos.READ readToProductName(String productName){

        final Product product = productRepository.findByProductsNames(productName)
                .orElseThrow(() -> new NotFoundException());

        return productMapper.toReadDto(product);
    }

    @Transactional
    public void updateProduct(ProductReqDtos.UPDATE update){

        Product product = productRepository.findById(update.getProductId())
                        .orElseThrow(() -> new NotFoundException());

        checkProductNamesMatch(product.getProductsNames(), update.getProductsNames());

        product.updateProduct(update);

        productRepository.save(product);
    }


    @Transactional
    public void deleteProduct(ProductReqDtos.DELETE delete){

        final Product product = productRepository.findByProductsNames(delete.getProductsNames())
                .orElseThrow(() -> new NotFoundException());

        productRepository.delete(product);
    }

    private void checkProductsNames(String productsNames){
        if (productRepository.existsByProductsNames(productsNames))
            throw new DuplicatedProductNameException();
    }

    private void checkProductNamesMatch(String name, String newName){
        if (productRepository.existsByProductsNames(name).equals(newName))
            throw new DuplicatedProductNameException();
    }
}
