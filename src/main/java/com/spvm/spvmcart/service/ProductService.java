package com.spvm.spvmcart.service;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.repository.ProductRepo;
import com.spvm.spvmcart.spec.ProductSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;//Instance of ProductRepo (Bean Object)

    public Map<String, Object> getAllProducts(int pageNumber, int pagesize){//pageNumber starts 0, content in page is EX:5
        Pageable pageable = PageRequest.of(pageNumber,pagesize);//PageRequest class return object of Pageable interface
        Page<Product> products = productRepo.findAll(pageable);//it will return the page of products
        Map<String,Object> response = new HashMap();
        response.put("products", products.getContent());//getContent() return Object (group of data from a page) in the JSON Object
        response.put("totalProducts",products.getTotalElements());//getTotalElements() return total product count EX:10
        return response;
    }
    public Product getProductById(Long id){
        return productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found with the id of "+id));//Optional (or) orElseThrow();
    }

    public List<Product> searchProducts(String category, Double minPrice, Double maxPrice, String keyword, Double ratings){
        Specification<Product> spec = Specification.where(
                ProductSpecification.hasCategory(category)
                .and(ProductSpecification.priceBetween(minPrice,maxPrice))
                .and(ProductSpecification.hasNameOrDescriptionLike(keyword)).and(ProductSpecification.ratingGraterThan(ratings))
        );//Specification Interface provided by JPA
        System.out.println("Ratings filter2: " + ratings);
        return productRepo.findAll(spec);
    }
}
