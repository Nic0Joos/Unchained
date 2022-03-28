package com.unchained.Unchained.api;

import com.unchained.Unchained.Data.Domain.Product;
import com.unchained.Unchained.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

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
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{productId}").buildAndExpand(product.getProductId()).toUri();

        return ResponseEntity.created(location).body(product);
    }

    @GetMapping(path = "/product", produces = "application/json")
    public List<Product> getProducts(){
        return productService.getAllProducts();
    }

    @PutMapping(path = "/product/{productId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Product> putproduct(@RequestBody Product product, @PathVariable(value = "productId") String productId) {
        try {
            product.setProductId(Long.parseLong(productId));
            product = productService.editProduct(product);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().body(product);
    }

    @DeleteMapping(path = "/product/{productId}")
    public ResponseEntity<Void> deleteproduct(@PathVariable(value = "productId") String productId) {
        try {
            productService.deleteproduct(Long.parseLong(productId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, e.getMessage());
        }
        return ResponseEntity.accepted().build();
    }
}
