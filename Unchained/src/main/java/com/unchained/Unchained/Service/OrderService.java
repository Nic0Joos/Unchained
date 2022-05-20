package com.unchained.Unchained.Service;

import com.unchained.Unchained.Data.Domain.Ordering;
import com.unchained.Unchained.Data.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

//Author: Luca
@Service
public class OrderService {



    @Autowired
    private OrderRepository orderRepository;

    public Ordering saveOrder(@Valid Ordering ordering) throws Exception {
        if (ordering.getShippingCost() <= 0) {
            throw new Exception("Shipping costs cannot be below 0");
        }
        return orderRepository.save(ordering);
    }


    public List<Ordering> findAllOrders() {
        List<Ordering> orderingList = new ArrayList<Ordering>();
        orderingList.addAll(orderRepository.findAll());
        return orderingList;
    }
}
