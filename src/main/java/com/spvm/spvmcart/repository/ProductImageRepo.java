package com.spvm.spvmcart.repository;

import com.spvm.spvmcart.entity.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductImageRepo extends JpaRepository<ProductImage,Long> {//CRUD will be done here
}
