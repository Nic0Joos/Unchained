package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.Product;
import com.unchained.Unchained.Data.Domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

//Author: Lennart
@Component
public class StartUpService implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    ProductService productService;


    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        this.createAdmin();
        this.createProducts();
    }

    private void createAdmin() {

        try {
            userDetailsServiceImp.saveUser(new User("admin", "Peter-Merian-Strasse 86", 4052, "Basel", 1, "admin@unchained.com", true, "adminpassword"));
        } catch (Exception e) {
            e.printStackTrace();
        }

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
    }


}
