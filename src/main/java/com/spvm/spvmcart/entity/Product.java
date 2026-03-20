package com.spvm.spvmcart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

import java.util.List;

@Entity //-> All annotation is called as Decorator
@Table(name = "products")
public class Product {
    @Id//Id is a primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)//To auto-generate the id for the object
    private Long id;

    @Column(nullable = false)//nullable constraint - NO
    @NotBlank(message = "Name field is required")//for String => This annotation from validation dependency
    private String name;

    @Column(nullable = false)//nullable constraint - NO
    @NotNull(message = "Price field is required")//for Integer => annotation from validation dependency
    @PositiveOrZero(message = "Value must be zero or greater than zero")
    private Double price;


    private String description;

    private Double ratings = 0.0; //YES

    @NotBlank(message = "Seller field is required") //NO
    private String seller;

    @NotNull(message = "Stock field is required")//NO
    private Integer stock;

    private Integer numOfReviews = 0;//YES

    /*CascadeType.ALL => If parent table is affected, the child table also gets affected
    * orphanRemoval = true => if product data is deleted, the child data is also deleted*/
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")//Primary key of this Product table is present as foreign key in ProductImage
    private List<ProductImage> images;//The product has multiple images

    /*CascadeType.ALL => If parent table is affected, the child table also gets affected
     * orphanRemoval = true => if product data is deleted, the child data is also deleted*/
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductReview> reviews;//The product has multiple reviews

    /*
     CascadeType.ALL
     ===============
     Save parent - Saves children
     Update parent - Updates children
     Delete parent - Deletes children

     orphanRemoval = true
     ====================
     Remove child from list - Deletes that child
    */
    public Product(Long id, String name, Double price,
                   String description, Double ratings,
                   String seller, Integer stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
    }
    public Product(){//default constructor for entity

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRatings() {
        return ratings;
    }

    public void setRatings(Double ratings) {
        this.ratings = ratings;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getNumOfReviews() {
        return numOfReviews;
    }

    public void setNumOfReviews(Integer numOfReviews) {
        this.numOfReviews = numOfReviews;
    }
}
