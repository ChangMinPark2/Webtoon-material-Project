package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;
import project.nftshop.service.service.ProductService;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "http://localhost:63342", allowCredentials = "true")
public class ProductController {

    private final ProductService productService;

    /**
     * 연동 성공
     * */
    @PostMapping
    public ResponseFormat createProduct(@RequestPart("create") ProductReqDtos.CREATE create,
                                        @RequestPart("file") MultipartFile file) throws IOException {
        productService.createProduct(create, file);
        return ResponseFormat.ok();
    }

    /**
     * 연동 성공
     * */
    @GetMapping
    public ResponseFormat<ProductResDtos.READ> readToProductNames(@RequestParam(name = "productName") String productName){
            return ResponseFormat.ok(productService.readToProductName(productName));
    }

    @GetMapping("/save")
    public ResponseFormat<ProductResDtos.READ> readSaveName(@RequestParam(name = "productName") String productName){
        return ResponseFormat.ok(productService.getSaveName(productName));
    }

    @GetMapping("/myProduct")
    public ResponseFormat<ProductResDtos.READ_MY_PRODUCT> readToMyProducts(@RequestParam(name = "identity") String identity){
        return ResponseFormat.ok(productService.getMyProducts(identity));
    }

    @GetMapping("/all")
    public ResponseFormat<List<ProductResDtos.READ_ALL_PRODUCT_IMAGE>> readAll(){
        return ResponseFormat.ok(productService.getAll());
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
