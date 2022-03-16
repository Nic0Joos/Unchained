package com.unchained.Unchained.api;

import com.unchained.Unchained.Data.Domain.Product;
import com.unchained.Unchained.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(path ="/api")
public class ProductEndpoint {

    @Autowired
    private ProductService productService;

    @PostMapping(path = "/product,", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> postProduct(@RequestBody Product product){

        try {
            productService.saveProduct(product);
        } catch (Exception e) {

        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(product.getProductId()).toUri();

        return ResponseEntity.created(location).body(product);
    }

}
