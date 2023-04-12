package com.lma.ecommerce.Interfaces;

import com.lma.ecommerce.Entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductInterface {

    public List<Product> getProducts();

    public Product findProduct(Long id);

    public void saveProduct(Product product);

    public void deleteProduct(Long id);

    public void updateProduct(Product product);
}



