package com.ups.oop.Service;


import com.ups.oop.DTO.ProductDTO;
import com.ups.oop.Entity.Product;
import com.ups.oop.Repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
    public class ProductService {
        private final ProductRepository productRepository;

        private List<ProductDTO> productDTOList = new ArrayList<>();

        public ProductService(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }

        public ResponseEntity createProduct(ProductDTO productDTO) {
            boolean wasFound = findProduct(String.valueOf(productDTO.getId()));
            if (wasFound) {
                String errorMessage = "product with id" + productDTO.getId() + "already exists";
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
            } else {
                productDTOList.add(productDTO);
                return ResponseEntity.status(HttpStatus.OK).body(productDTO);
            }
        }

        private boolean findProduct(String id) {
            for (ProductDTO productDTO : productDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(productDTO.getId()))) {
                    return true;
                }
            }
            return false;
        }

        public ResponseEntity getAllProduct() {
            Iterable<Product> productIterable = productRepository.findAll();
            List<ProductDTO> products = new ArrayList<>();
            for (Product p : productIterable) {
                ProductDTO product = new ProductDTO();
                product.setId(product.getId());
                product.setName(product.getName());
                product.setProvider(product.getProvider());
                product.setDescription(product.getDescription());
                product.setPrice(product.getPrice());
                products.add(product);

            }
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product List not found");
            }
            return ResponseEntity.status(HttpStatus.OK).body(products);
        }

        public ResponseEntity getProductById(Long id) {
            Optional<Product> productOptional = productRepository.findById(Long.valueOf(id));
            if(productOptional.isPresent()){
                Product productFound = productOptional.get();
                ProductDTO product = new ProductDTO();
                product.setId(Long.valueOf(productFound.getId()));
                product.setName(productFound.getName());
                product.setProvider(productFound.getProvider());
                product.setDescription(productFound.getDescription());
                product.setPrice(productFound.getPrice());


                return  ResponseEntity.status(HttpStatus.OK).body(product);

            }else{

                String errorMessage = "product with id" + id + " already exists";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
            }

        }

        private int findIndexById(String id) {
            int index = 0;
            for (ProductDTO in : productDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(in.getId()))) {
                    return index;
                }
                index++;
            }
            return -1;

        }

        public ResponseEntity updateProduct(ProductDTO productDTO) {
            int upadateIndex = findIndexById(String.valueOf(productDTO.getId()));
            if (upadateIndex != -1) {
                productDTOList.set(upadateIndex, productDTO);
                return ResponseEntity.status(HttpStatus.OK).body(productDTO);
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("product with id " + productDTO.getId() + " doesn't exits ");

        }

        public ResponseEntity deleteProductById(String id) {
            String message = "invoice with id " + id;
            for (ProductDTO p : productDTOList) {
                if (id.equalsIgnoreCase(String.valueOf(p.getId()))) {
                    productDTOList.remove(p);
                    return ResponseEntity.status(HttpStatus.OK).body(message + " removed successfully");
                }
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message + " not found");
        }
    }

