package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.model.ErrorCodeType;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;
import project.nftshop.service.service.ProductService;

import java.io.IOException;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class ProductController {

    private final ProductService productService;

//    @PostMapping
//    public ResponseFormat createProduct(@RequestPart("file") MultipartFile file,
//                                        @RequestPart("create") ProductReqDtos.CREATE create) {
//        productService.createProduct(file, create);
//        return ResponseFormat.ok();
//    }

    @PostMapping
    public ResponseEntity<?> createFile(@RequestPart("file") MultipartFile file){
//
//        String saveName = productService.hhjFileCreate(f);

        return null;
    }

    @GetMapping
    public ResponseEntity<?> readToProductNames(@RequestParam(name = "productName") String productName){
//        try {
//            return ResponseFormat.ok(productService.readToProductName(productName));
//        } catch (IOException e){
//            return ResponseFormat.fail("실행실패입니다.");
//        }
        return null;
    }


    @PutMapping
    public ResponseFormat updateProduct(@RequestBody ProductReqDtos.UPDATE update){

        productService.updateProduct(update);
        return ResponseFormat.ok();
    }

    @DeleteMapping
    public ResponseFormat deleteProduct(@RequestBody ProductReqDtos.DELETE delete){

        productService.deleteProduct(delete);
        return ResponseFormat.ok();
    }
}
