package com.unchained.Unchained.Service;


import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unchained.Unchained.Data.Repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

//Author: Kaan
@Service
public class ProductService {

    //TODO: Log to file

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }


    public List<Product> getAllProducts() {

        List<Product> defaultProductList = new ArrayList<>();

        for (Product p: productRepository.findAll()) {
            defaultProductList.add(p);
        }
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
