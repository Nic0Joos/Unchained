package com.unchained.Unchained.Data.Repository;

import com.unchained.Unchained.Data.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
