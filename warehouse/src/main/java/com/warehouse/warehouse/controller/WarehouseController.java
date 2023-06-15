package com.warehouse.warehouse.controller;

import com.warehouse.warehouse.model.Duckling;
import com.warehouse.warehouse.model.Order;
import com.warehouse.warehouse.model.OrderResponse;
import com.warehouse.warehouse.service.DucklingService;
import com.warehouse.warehouse.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ducklings", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
//@ControllerAdvice
public class WarehouseController {
    //write all apis here
    @Autowired
    DucklingService ducklingService;

    @Autowired
    OrderService orderService;

    /**
     * This is a test API
     * @return
     */
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok().body("Hello");
    }

    /**
     * This will return all the records from DB
     * @return
     */
    @GetMapping("/getall")
    public ResponseEntity<List<Duckling>> getAll(){
        return ResponseEntity.ok().body(ducklingService.getAll());
    }

    /**
     * This will return all the active records from DB
     * @return
     */
    @GetMapping("/getallactive")
    public ResponseEntity<List<Duckling>> getAllActive(){
        return ResponseEntity.ok().body(ducklingService.getAllActive());
    }

    /**
     * This will add a new record
     * if duckling with size and color is not present
     * else quantity of existing record is added up
     * @param duckling
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Duckling> addDuckling(@RequestBody Duckling duckling) {
        return ResponseEntity.ok().body(ducklingService.add(duckling));
    }

    /**
     * This is soft delete API
     * it will update the delete flag to true of passed id
     * @param id
     * @return
     */
    @PutMapping("/delete/{id}")
    public ResponseEntity<Duckling> deleteDuckling(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok().body(ducklingService.delete(id));
    }

    /**
     * Edit functionality to update price and quantity
     * @param duckling
     * @return
     */
    @PutMapping("/edit")
    public ResponseEntity<Duckling> editDuckling(@RequestBody Duckling duckling) {
        return ResponseEntity.ok().body(ducklingService.edit(duckling));
    }

    @RequestMapping(value = "/shop",
            method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.placeOrder(order));
    }

}
