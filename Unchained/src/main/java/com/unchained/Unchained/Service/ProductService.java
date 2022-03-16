package com.unchained.Unchained.Service;


import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.unchained.Unchained.Data.Repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
