package com.spvm.spvmcart.controller;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController//This Controller for REST APIs
@RequestMapping("/api/products")//Parent endpoint
public class ProductController {

    //Otherwise bean object for ProductService will not be created
    @Autowired
    ProductService productService;

    @GetMapping
    public Map<String, Object> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber,//page starts from 0
                                                              @RequestParam(defaultValue = "5") int pagesize){//5 objects in the page

           return productService.getAllProducts(pageNumber,pagesize);//Return in the form of JSON
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
       return productService.getProductById(id);
    }

    @GetMapping("/search")
    public List<Product> searchProducts(@RequestParam(required = false) String category,
                                        @RequestParam(required = false) Double minPrice,//Wrapper class accepts null value
                                        @RequestParam(required = false) Double maxPrice,//Wrapper class accepts null value
                                        @RequestParam(required = false) String keyword,
                                        @RequestParam(required = false) Double ratings){
        return productService.searchProducts(category, minPrice, maxPrice, keyword, ratings);
    }
}
