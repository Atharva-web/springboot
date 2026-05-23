//package com.module3.SpringDataJPA.controller;
//
//import com.module3.SpringDataJPA.entities.ProductEntity;
//import com.module3.SpringDataJPA.repositories.ProductRepository;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/products")
//public class ProductController {
//
//    private final ProductRepository productRepository;
//
//    public ProductController(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }
//
//    @GetMapping("/{title}")
//    public List<ProductEntity> getProductsByTitleOrderByPrice(@PathVariable String title) {
//        return productRepository.findByTitleOrderByPriceDesc(title);
//    }
//
//    @GetMapping
//    public List<ProductEntity> getAllProducts() {
//        return productRepository.findByOrderByPrice();
//    }
//}
