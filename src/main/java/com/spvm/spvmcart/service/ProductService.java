package com.spvm.spvmcart.service;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
}
