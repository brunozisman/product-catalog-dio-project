package com.bnz.productcatalog.controller;

import com.bnz.productcatalog.exception.ProductNotFoundException;
import com.bnz.productcatalog.model.Product;
import com.bnz.productcatalog.repository.ProductRepository;
import com.bnz.productcatalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Product create(@RequestBody Product product) {

        return productService.create(product);
    }

    @GetMapping(value = "/{id}")
    public Product findById(@PathVariable Long id) throws ProductNotFoundException {
        return productService.findById(id);
    }

}
