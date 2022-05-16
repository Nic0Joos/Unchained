package com.unchained.Unchained.Controller;

import com.unchained.Unchained.Data.Domain.Order;
import com.unchained.Unchained.Service.LoggerService;
import com.unchained.Unchained.Service.OrderService;
import com.unchained.Unchained.Service.UserDetailsServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping (path = "/api")
public class OrderEndpoint {


    @Autowired
    private OrderService orderService;

    @Autowired
    private UserDetailsServiceImp userDetailsServiceImp;

    @Autowired
    private LoggerService loggerService;

    @PostMapping(path = "/order", consumes = "application/json",produces = "application/json")
    public ResponseEntity<Order> postOrder(@RequestBody Order order){
        try {
            order.setUser(userDetailsServiceImp.getCurrentUser());
            orderService.saveOrder(order);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
            // LoggerService.logSystem("warning", "Order couldn't be processed: " + e.toString());
        }
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{orderId}").buildAndExpand(order.getOrderId()).toUri();
        return ResponseEntity.created(location).body(order);
    }

    //all orders
    @GetMapping(path="/order", produces = "application/json")
    public List<Order> getAllOrders() {
        return orderService.findAllOrders();
    }

    //Put and Delete of orders forbidden
    @PutMapping(path="/order/{orderID}")
    public Exception putOrder() {
        return new ResponseStatusException(HttpStatus.FORBIDDEN);
    }

    @DeleteMapping(path="/order/{orderID}")
    public Exception deleteOrder() {
        return new ResponseStatusException(HttpStatus.FORBIDDEN);
    }


}
