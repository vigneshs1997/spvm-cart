package com.spvm.spvmcart.seed;

import com.spvm.spvmcart.entity.Product;
import com.spvm.spvmcart.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProductSeeder implements CommandLineRunner {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public void run(String... args) throws Exception {
        /*The default data will be seeded whenever we run the project*/
        if(productRepo.count() == 0){
          List<Product> demoProducts = List.of(new Product(null, "Apple iPhone 15", 799.0, "Smartphone with A16 Chip", 4.8, "Amazon", 5),
                  new Product(null, "Samsung Galaxy S23", 749.0, "Flagship Android phone with Snapdragon processor", 4.7, "Flipkart", 8),
                  new Product(null, "OnePlus 11", 699.0, "Fast performance with OxygenOS", 4.6, "Amazon", 10),
                  new Product(null, "Google Pixel 7", 599.0, "Best camera smartphone with clean Android", 4.7, "Flipkart", 6),
                  new Product(null, "iQOO Neo 7", 499.0, "Gaming smartphone with Dimensity processor", 4.5, "Amazon", 12),
                  new Product(null, "Redmi Note 12 Pro", 399.0, "Budget phone with good camera and battery", 4.4, "Flipkart", 15),
                  new Product(null, "Realme GT 3", 429.0, "Fast charging and performance focused phone", 4.3, "Amazon", 9),
                  new Product(null, "Nothing Phone 2", 649.0, "Unique design with clean UI", 4.6, "Flipkart", 7),
                  new Product(null, "Motorola Edge 40", 579.0, "Near stock Android experience", 4.5, "Amazon", 11),
                  new Product(null, "Asus ROG Phone 7", 999.0, "Ultimate gaming smartphone with high refresh rate", 4.8, "Flipkart", 4));
          productRepo.saveAll(demoProducts);
          System.out.println("Seeded Demo Products!");
        }else {
            System.out.println("Product Already Exists! so Skipping seed");
        }
    }
}
