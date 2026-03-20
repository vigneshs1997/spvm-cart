package com.spvm.spvmcart.controller;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController//This Controller for REST APIs
@RequestMapping("/api/products")//Parent endpoint
public class ProductController {
    //Otherwise bean object for ProductService will not be created
    @Autowired
    ProductService productService;
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts(){
           List<Product> products =  productService.getAllProducts();
           return ResponseEntity.ok(products);//Return in the form of JSON
    }
}
