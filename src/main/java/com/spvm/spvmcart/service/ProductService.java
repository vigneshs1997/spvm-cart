package com.spvm.spvmcart.service;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;//Instance of ProductRepo (Bean Object)

    public List<Product> getAllProducts(){
        List<Product> products = productRepo.findAll();
        return products;
    }
}
