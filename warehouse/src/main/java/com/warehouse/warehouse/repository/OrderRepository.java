package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, Integer> {
}
