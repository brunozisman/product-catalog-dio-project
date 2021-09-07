package com.bnz.productcatalog.service;

import com.bnz.productcatalog.exception.ProductNotFoundException;
import com.bnz.productcatalog.model.Product;
import com.bnz.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public Product findById(Long id) throws ProductNotFoundException {

        return verifyIfExists(id);
    }

    private Product verifyIfExists(Long id) throws ProductNotFoundException {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
