package com.unchained.Unchained.Data.Repository;

import com.unchained.Unchained.Data.Domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
