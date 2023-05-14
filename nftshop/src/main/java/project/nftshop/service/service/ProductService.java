package project.nftshop.service.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.exception.DuplicatedProductNameException;
import project.nftshop.infra.error.exception.FileProcessingException;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.service.model.mapper.ProductMapper;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.UUID;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Data
public class ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    private final RestTemplateBuilder restTemplateBuilder;

//    @Transactional
    public void createProduct(MultipartFile image, ProductReqDtos.CREATE create) {
//        try {
//            // 이미지 데이터와 이미지 파일 이름 가져오기
//            byte[] imageData = image.getBytes();
//            String imageName = image.getOriginalFilename();
//
//            // 이미지 파일 저장
//            String savedImagePath = saveImage(imageData, imageName);
//
//            final Product product = productMapper.toProductEntity(create, savedImagePath);
//            //savedImagePath -> 인코딩된 문자열
//            checkProductsNames(create.getProductsNames());
//
//            productRepository.save(product);
//        } catch (IOException e) {
//            // 파일 처리 오류 처리
//            throw new FileProcessingException();
//        }
    }


    public ProductResDtos.READ readToProductName(String productName) throws IOException{
//
//        final Product product = productRepository.findByProductsNames(productName)
//                .orElseThrow(() -> new NotFoundException());
//
//        byte[] imageBytes = readImageBytes(product.getSavedImagePath()); // 인코딩된
//
//       // String imgBase64 = encodeImage(imageBytes); // 인코딩된 문자열을 디코딩으로 변환해서 String?
//
//        return productMapper.toReadDto(product, imageBytes);
        return null;
    }

    private String encodeImage(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }


    private byte[] readImageBytes(String imagePath) throws IOException {
//        File imageFile = new File(imagePath);
//        InputStream inputStream = new FileInputStream(imageFile);
//        byte[] imageBytes = IOUtils.toByteArray(inputStream);
//        inputStream.close();
//        return imageBytes;

        return null;
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

    private String saveImage(byte[] imageData, String imageName) throws IOException {
//        // 저장할 이미지 파일 경로 생성
//        String savedImagePath = imageUploadDirectory + File.separator + imageName;
//        Path targetPath = Path.of(savedImagePath);
//
//        // 디렉토리가 없으면 생성
//        Files.createDirectories(targetPath.getParent());
//
//        // 이미지 파일 저장
//        Files.write(targetPath, imageData);
//
//        return savedImagePath;
        return null;
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
