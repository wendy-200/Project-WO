package com.ups.oop.Controller.entity;


import com.ups.oop.Service.ProductService;
import com.ups.oop.DTO.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService= productService;
    }

    @GetMapping("/get-all-products")
    public ResponseEntity getProducts() {
        return this.productService.getAllProduct();
    }

    @GetMapping("/get-product")
    public ResponseEntity getProductById(@RequestParam Long id) {
        return this.productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity createProduct(@RequestBody ProductDTO productDTO) {
        return this.productService.createProduct(productDTO);
    }


    @PutMapping("/update-product")
    public ResponseEntity updateProduct(@RequestBody ProductDTO productDTO){
        return this.productService.updateProduct(productDTO);
    }

    @DeleteMapping("/remove-product")
    public ResponseEntity deleteProduct(@RequestParam String id){
        return this.productService.deleteProductById(id);
    }
}