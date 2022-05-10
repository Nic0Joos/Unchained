package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class StartUpService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    ProductService productService;

    private boolean runsProductive = false;
    private boolean adminCreated = false;
    private boolean productsCreated = false;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        try {
            runsProductive = System.getenv("RUN_PROD").equals("prod");
        } catch(NullPointerException e) {
            runsProductive = false;
        }

        if (!adminCreated)
            this.createAdmin();
        if (!productsCreated)
            this.createProducts();

    }

    private void createAdmin() {

    }

    private void createProducts() {

        try {
        productService.saveProduct(new Product("Prod. A", 25L, 1.2, 13.50));
        productService.saveProduct(new Product("Prod. B",  10L, 2.0, 15.0));
        productService.saveProduct(new Product("Prod. C",  15L, 2.5, 11.90));
        productService.saveProduct(new Product("Prod. D", 100L, 0.8, 2.50));

        } catch (Exception e) {
            e.printStackTrace();
        }
        productsCreated = true;
    }


}
