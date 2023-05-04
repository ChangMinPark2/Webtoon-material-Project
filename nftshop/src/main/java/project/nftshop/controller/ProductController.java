package project.nftshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import project.nftshop.infra.error.model.ResponseFormat;
import project.nftshop.service.model.request.ProductReqDtos;
import project.nftshop.service.model.response.ProductResDtos;
import project.nftshop.service.service.ProductService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseFormat createProduct(@RequestBody ProductReqDtos.CREATE create){

        productService.createProduct(create);
        return ResponseFormat.ok();
    }

    @GetMapping
    public ResponseFormat<ProductResDtos.READ> readToProductNames(@RequestParam(name = "productName") String productName){
        return ResponseFormat.ok(productService.readToProductName(productName));
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
