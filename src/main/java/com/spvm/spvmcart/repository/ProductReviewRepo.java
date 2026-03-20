package com.spvm.spvmcart.repository;

import com.spvm.spvmcart.entity.ProductReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductReviewRepo extends JpaRepository<ProductReview,Long> {//CRUD will be done here
}
