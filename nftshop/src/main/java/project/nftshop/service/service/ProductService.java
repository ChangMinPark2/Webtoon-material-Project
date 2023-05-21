package project.nftshop.service.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.exception.DuplicatedProductNameException;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.infra.error.exception.WrongPasswordException;
import project.nftshop.persistence.entity.*;
import project.nftshop.persistence.repository.ImageFileRepository;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.persistence.repository.UserProductRepository;
import project.nftshop.persistence.repository.UserRepository;
import project.nftshop.service.model.mapper.ProductMapper;
import project.nftshop.service.model.mapper.UserProductMapper;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;
import java.io.IOException;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Data
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final RestTemplateBuilder restTemplateBuilder;

    private final ImageFileRepository imageFileRepository;

    private final ImageFileService imageFileService;

    private final UserRepository userRepository;

    private final UserProductRepository userProductRepository;

    private final UserProductMapper userProductMapper;

    @Transactional
    public void createProduct(ProductReqDtos.CREATE create, MultipartFile file) throws IOException {

        final User user = userRepository.findByIdentity(create.getIdentity())
                .orElseThrow(() -> new NotFoundException());

        checkPasswordMatch(user.getPassword(), create.getPassword());

        ImageFile imageFile = imageFileService.hhjFileCreate(file);

        final Product product = productMapper.toProductEntity(create, imageFile);

        checkProductsNames(create.getProductsNames());

        UserProduct userProduct = userProductMapper.toOrderProductEntity(user, product);

        userProductRepository.save(userProduct);

        productRepository.save(product);
    }

    /**
     *  성공
     * */
    public ProductResDtos.READ readToProductName(String productName){

        final Product product = productRepository.findByProductsNames(productName)
                .orElseThrow(() -> new NotFoundException());

        ProductResDtos.READ readToProduct = productMapper.toReadDto(product);

        return readToProduct;
    }

    public ProductResDtos.READ_SAVE_NAME getSaveName(String productName){
        final Product product = productRepository.findByProductsNames(productName)
                .orElseThrow(() -> new NotFoundException());

        ProductResDtos.READ_SAVE_NAME readSaveName = ProductResDtos.READ_SAVE_NAME.builder()
                .saveName(product.getImageFile().getSaveName())
                .build();

        return readSaveName;
    }

    public ProductResDtos.READ_MY_PRODUCT getMyProducts(String identity) {
        List<String> productNames = userProductRepository.findProductNamesByUserIdentity(identity);
        return ProductResDtos.READ_MY_PRODUCT
                .builder()
                .productsNames(productNames)
                .build();
    }

    @Transactional
    public void updateProduct(ProductReqDtos.UPDATE update){

        Product product = productRepository.findByProductsNames(update.getProductsNames())
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

    private void checkPasswordMatch(String originPassword, String checkPassword){
        if(!originPassword.equals(checkPassword))
            throw new WrongPasswordException();
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
