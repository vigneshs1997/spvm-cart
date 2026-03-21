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
          List<Product> demoProducts = List.of(
                  new Product(null, "Apple iPhone 15", 799.0, "Smartphone with A16 Chip", "Phone", 4.8, "Amazon", 5),
                  new Product(null, "Samsung Galaxy S23", 749.0, "Flagship Android phone with Snapdragon processor", "Phone", 4.7, "Flipkart", 8),
                  new Product(null, "OnePlus 11", 699.0, "Fast performance with OxygenOS", "Phone", 4.6, "Amazon", 10),

                  new Product(null, "MacBook Air M2", 1199.0, "Lightweight laptop with Apple M2 chip", "Laptop", 4.9, "Amazon", 6),
                  new Product(null, "Dell XPS 13", 999.0, "Premium ultrabook with InfinityEdge display", "Laptop", 4.7, "Flipkart", 4),

                  new Product(null, "Sony Alpha A7 III", 1999.0, "Full-frame mirrorless camera", "Camera", 4.8, "Amazon", 3),
                  new Product(null, "Canon EOS R50", 899.0, "Compact mirrorless camera for beginners", "Camera", 4.6, "Flipkart", 7),

                  new Product(null, "JBL Flip 6", 129.0, "Portable Bluetooth speaker with deep bass", "Speaker", 4.5, "Amazon", 15),
                  new Product(null, "Sony SRS-XB43", 199.0, "Extra bass wireless speaker", "Speaker", 4.6, "Flipkart", 9),

                  new Product(null, "Sony WH-1000XM5", 349.0, "Noise cancelling headphones", "Headphone", 4.8, "Amazon", 10),
                  new Product(null, "Boat Rockerz 550", 79.0, "Affordable wireless headphones", "Headphone", 4.3, "Flipkart", 20),

                  new Product(null, "LG OLED C3", 1499.0, "4K OLED Smart TV", "TV", 4.9, "Amazon", 5),
                  new Product(null, "Samsung Crystal 4K TV", 799.0, "Affordable 4K Smart TV", "TV", 4.6, "Flipkart", 8),

                  new Product(null, "HP Pavilion Desktop", 699.0, "Desktop computer for daily use", "Computer", 4.4, "Amazon", 6),
                  new Product(null, "Lenovo ThinkCentre", 799.0, "Business desktop computer", "Computer", 4.5, "Flipkart", 5)
          );

          productRepo.saveAll(demoProducts);
          System.out.println("Seeded Demo Products!");
        }else {
            System.out.println("Product Already Exists! so Skipping seed");
        }
    }
}
