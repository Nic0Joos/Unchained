package com.unchained.Unchained.Service;


import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unchained.Unchained.Data.Repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    //TODO: Log to file

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
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
