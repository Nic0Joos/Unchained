package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.Order;
import com.unchained.Unchained.Data.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Validated
public class OrderService {

    //TODO: Log to file

    @Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(@Valid Order order) throws Exception {
        if (order.getShippingCost() <= 0) {
            throw new Exception("Shipping costs cannot be below 0");
        }
        return orderRepository.save(order);
    }


    public List<Order> findAllOrders() {
        List<Order> orderList = new ArrayList<Order>();
        orderList.addAll(orderRepository.findAll());
        return orderList;
    }
}
