package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping
    public ResponseFormat createProduct(@RequestPart("create") ProductReqDtos.CREATE create,
                                        @RequestPart("file") MultipartFile file) throws IOException {
        productService.createProduct(create, file);
        return ResponseFormat.ok();
    }

    @GetMapping
    public ResponseFormat<ProductResDtos.READ> readToProductNames(@RequestParam(name = "productName") String productName){
            return ResponseFormat.ok(productService.readToProductName(productName));
    }

    @GetMapping("/myProduct")
    public ResponseFormat<ProductResDtos.READ_MY_PRODUCT> readToMyProducts(@RequestParam(name = "identity") String identity){
        return ResponseFormat.ok(productService.getMyProducts(identity));
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
