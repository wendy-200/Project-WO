package com.ups.oop.Service;

import com.ups.oop.dto.ProductDTO;
import com.ups.oop.entity.Product;
import com.ups.oop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> getAllProducts() {
        Iterable<Product> productIterable = productRepository.findAll();
        List<ProductDTO> productList = new ArrayList<>();

        for (Product product : productIterable) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getId());
            productDTO.setName(product.getName());
            productDTO.setProvider(product.getProvider());
            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());

            productList.add(productDTO);
        }

        return productList;
    }
}