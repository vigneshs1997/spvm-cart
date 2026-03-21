package com.spvm.spvmcart.spec;

import com.spvm.spvmcart.entity.Product;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpecification {
    public static Specification<Product> hasCategory(String category){
       return (root,
               criteriaQuery,
               criteriaBuilder) -> category == null ? null : criteriaBuilder.equal(
                       criteriaBuilder.lower(root.get("category")) ,category.toLowerCase()
       );
    }
    public static Specification<Product> priceBetween(Double min,Double max){
        return (root,
                criteriaQuery,
                criteriaBuilder)-> {
            if(min == null && max == null) return null;
            if(min == null) return criteriaBuilder.lessThanOrEqualTo(root.get("price"),max);//LessThanOrEqualTOMax
            if(max == null) return criteriaBuilder.greaterThanOrEqualTo(root.get("price"),min);//GreaterThanOrEqualToMin
            return criteriaBuilder.between(root.get("price"), min, max);//root price from product table
        };
    }
    public static Specification<Product> hasNameOrDescriptionLike(String keyword){
        return (root,
                criteriaQuery,
                criteriaBuilder)-> {
            if(keyword == null || keyword.isEmpty()) return null;
            String pattern = "%" + keyword.toLowerCase() + "%";
            return criteriaBuilder.or(
                  criteriaBuilder.like(criteriaBuilder.lower(root.get("name")),pattern),
                  criteriaBuilder.like(criteriaBuilder.lower(root.get("description")),pattern)
                 );
        };
    }
    public static Specification<Product> ratingGraterThan(Double ratings){
        return (root,
                criteriaQuery,
                criteriaBuilder)-> {
            if (ratings == null) return null;
            System.out.println("Ratings filter1: " + ratings);
            return criteriaBuilder.greaterThanOrEqualTo(root.get("ratings"),ratings);//GreaterThanOrEqualToMin
        };
    }
}
