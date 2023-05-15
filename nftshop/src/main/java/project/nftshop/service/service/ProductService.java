package project.nftshop.service.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.exception.DuplicatedProductNameException;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.persistence.entity.ImageFile;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.repository.ImageFileRepository;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.service.model.mapper.ProductMapper;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;
import java.io.IOException;

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

    @Transactional
    public void createProduct(ProductReqDtos.CREATE create, MultipartFile file) throws IOException {
        // 이미지 파일 생성
    //    imageFileService.hhjFileCreate(create.getMultipartFile());  //save ImageFile
        // 이미지 파일이 저장된 후에 해당 이미지 파일을 사용하여 Product 엔티티 생성

        ImageFile imageFile = imageFileService.hhjFileCreate(file);

        final Product product = productMapper.toProductEntity(create, imageFile);

        checkProductsNames(create.getProductsNames());

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




    private void checkProductsNames(String productsNames){
        if (productRepository.existsByProductsNames(productsNames))
            throw new DuplicatedProductNameException();
    }

    private void checkProductNamesMatch(String name, String newName){
        if (productRepository.existsByProductsNames(name).equals(newName))
            throw new DuplicatedProductNameException();
    }
}
