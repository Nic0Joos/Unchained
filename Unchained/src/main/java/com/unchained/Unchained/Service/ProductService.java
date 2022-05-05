package com.unchained.Unchained.Service;


import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unchained.Unchained.Data.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    //TODO: Log to file

    @Autowired
    private ProductRepository productRepository;

    //Default products
    static final List<Product> defaultProductList = new ArrayList<>();
    static final Product productA = new Product("Prod. A", 25L, 1.2, 13.50);
    static final Product productB = new Product("Prod. B",  10L, 2.0, 15.0);
    static final Product productC = new Product("Prod. C",  15L, 2.5, 11.90);
    static final Product productD = new Product("Prod. D", 100L, 0.8, 2.50);


    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> getAllProducts() {
        defaultProductList.add(productA);
        defaultProductList.add(productB);
        defaultProductList.add(productC);
        defaultProductList.add(productD);
        return defaultProductList;
    }


    public Product editProduct(Product product) throws Exception {
        if(productRepository.existsById(product.getProductId())) {
            return productRepository.save(product);
        } else {
            throw new Exception("Product not found");
        }
    }

    public void deleteproduct(long productId) throws Exception {
        if(productRepository.existsById(productId)) {
            productRepository.deleteById(productId);
        } else {
            throw new Exception("Product not found");
        }
    }
}
