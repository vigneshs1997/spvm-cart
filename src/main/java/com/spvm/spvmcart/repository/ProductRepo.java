package com.spvm.spvmcart.repository;

import com.spvm.spvmcart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {//CEUD will be done here

}
