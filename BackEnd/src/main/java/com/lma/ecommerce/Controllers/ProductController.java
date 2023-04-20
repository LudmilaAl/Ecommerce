package com.lma.ecommerce.Controllers;

import com.lma.ecommerce.DTO.ProductDTO;
import com.lma.ecommerce.Entities.Product;
import com.lma.ecommerce.Interfaces.ProductInterface;
import com.lma.ecommerce.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductInterface productInterface;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productInterface.getProducts();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id){
        return productInterface.findProduct(id);
    }

    @PostMapping("/newProduct")
    public ResponseEntity<String> saveProducts(@RequestBody ProductDTO input){

        Product product = new Product(input.getName(),
                input.getBrand(),
                input.getCategory(),
                input.getDescription(),
                input.getImageURL(),
                input.getPrice(),
                input.getStock());

        productInterface.saveProduct(product);
        return ResponseEntity.ok("Product added successfully!");
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<String> editProduct(@PathVariable Long id, @RequestBody ProductDTO input){

        Product product = productInterface.findProduct(id);
        product.setName(input.getName());
        product.setBrand(input.getBrand());
        product.setCategory(input.getCategory());
        product.setImageURL(input.getImageURL());
        product.setPrice(input.getPrice());
        product.setStock(input.getStock());
        product.setDescription(input.getDescription());

        productInterface.saveProduct(product);

        return ResponseEntity.ok("Product updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productInterface.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully!");
    }

}
