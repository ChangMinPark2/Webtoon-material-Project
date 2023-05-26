package project.nftshop.service.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.exception.NotFoundException;
import project.nftshop.persistence.entity.ImageFile;
import project.nftshop.persistence.entity.Product;
import project.nftshop.persistence.repository.ImageFileRepository;
import project.nftshop.persistence.repository.ProductRepository;
import project.nftshop.service.model.mapper.ProductMapper;
import project.nftshop.service.model.response.ProductResDtos;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ImageFileService {

    @Value("${image.upload.directory}")
    String FILE_PATH;

    private final ImageFileRepository fileRepository;

    private final ProductRepository productRepository;


    @Transactional
    public ImageFile hhjFileCreate(MultipartFile file) throws IOException { //매개변수 MultiFile 받고

        String originName = file.getOriginalFilename();

        String saveName = toSaveName(originName);

        file.transferTo(new File(getFullPath(saveName)));

        String contentType = file.getContentType();

        ImageFile create = ImageFile.builder()
                .fileName(originName)
                .saveName(saveName)
                .contentType(contentType)
                .build();

        fileRepository.save(create);

        return create;
    }

    public ResponseEntity<Resource> downloadImage(String saveName) throws IOException {
        ImageFile imageFile = fileRepository.findBySaveName(saveName)
                .orElseThrow(() -> new NotFoundException());

        File file = new File(getFullPath(saveName));
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + imageFile.getFileName());

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.parseMediaType(imageFile.getContentType()))
                .body(resource);
    }

    public ResponseEntity<?> hhjFileRead(String productsName) throws IOException {

        Product product = productRepository.findByProductsNames(productsName)
                .orElseThrow(() -> new NotFoundException());

        ImageFile imageFile = product.getImageFile();

        String saveFile = imageFile.getSaveName();

        String originName = imageFile.getFileName();

        String contentType = imageFile.getContentType();

        Path path = Paths.get(getFullPath(saveFile));

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentDisposition(
                ContentDisposition.builder("attachment")
                        .filename(originName, StandardCharsets.UTF_8)
                        .build()
        );

        httpHeaders.add(HttpHeaders.CONTENT_TYPE, contentType);

        Resource resource = new InputStreamResource(Files.newInputStream(path));

        return new ResponseEntity<>(resource, httpHeaders, HttpStatus.OK);
    }

    private String getFullPath(String saveName) {

        return FILE_PATH + saveName;
    }

    private String toSaveName(String originName) {

        String ext = extractExtension(originName);

        String uuid = UUID.randomUUID().toString();

        return uuid + "." + ext;
    }

    private String extractExtension(String originName) {

        int position = originName.lastIndexOf(".");

        return originName.substring(position + 1);
    }
}
