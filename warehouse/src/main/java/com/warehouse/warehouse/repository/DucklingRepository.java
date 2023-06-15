package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.model.Duckling;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DucklingRepository  extends MongoRepository<Duckling, Integer> {

    Duckling findByColorAndSizeAndPrice(String color, String size, double price);
    Duckling getById(int id);

}
