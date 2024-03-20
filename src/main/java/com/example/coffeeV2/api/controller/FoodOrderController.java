package com.example.coffeeV2.api.controller;

import com.example.coffeeV2.api.dto.DishRequest;
import com.example.coffeeV2.api.dto.FoodOrderResponse;
import com.example.coffeeV2.business.service.OrderService;
import com.example.coffeeV2.data.entity.Dish;
import com.example.coffeeV2.data.entity.OrderFood;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class FoodOrderController {

    @Autowired
    OrderService<OrderFood> service;
    private final Logger log = LoggerFactory.getLogger(FoodOrderController.class);
    @GetMapping()
    @Operation(summary = "Find all orders", description = "Return a list of all orders")
    public ResponseEntity<List<OrderFood>> findAll() {
        List<OrderFood>  foodOrders = service.findAll();
        if(!foodOrders.isEmpty()){
            return ResponseEntity.ok(foodOrders);
        } else{
            return ResponseEntity.notFound().build();
        }
        /*
             List<FoodOrderResponse> allFoodOrders = new ArrayList<>();
        List<OrderFood>  foodOrders = service.findAll();
        for(OrderFood currentOrder : foodOrders){
            List<OrderFoodLine> orderFoodLineList = currentOrder.getOrderFoodLineList();
            for(OrderFoodLine o : orderFoodLineList){
                allFoodOrders.add(FoodOrderResponse.from(service.findById(o.getOrderFood().getId())));
            }

        }
        if(!allFoodOrders.isEmpty()){
            return ResponseEntity.ok(allFoodOrders);
        } else{
            return ResponseEntity.notFound().build();
        }
         */
    }


    @GetMapping("/{id}")
    @Operation(summary = "Find order", description = "Find a order (PK)")
    public ResponseEntity<FoodOrderResponse> findOneById(@PathVariable Long id) {
        OrderFood order = service.findById(id);
        if (order != null) {
            return ResponseEntity.ok(FoodOrderResponse.from(order));
        } else {
           return  ResponseEntity.badRequest().build();
        }


    }
    @PostMapping()
    @Operation(summary = "Create orders", description = "Create orders")
    public ResponseEntity<OrderFood> create(@RequestBody OrderFood orderFood) {
        if (orderFood != null) {
            if(service.exist(orderFood.getId())){
                log.warn("Trying to create a Order with ID");
                return ResponseEntity.badRequest().build();
            }
            OrderFood result = service.save(orderFood);
            return ResponseEntity.ok(result);
        } else{
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/kitchen/{id}")
    @Operation(summary = "Find all OrderLines by ID", description = "Find a orderLines  by ID(PK)")
    public ResponseEntity<List<FoodOrderResponse>> findAllOrderLinesbyID(@PathVariable Long id) {
        OrderFood order = service.findById(id);
        if (order != null) {
            return ResponseEntity.ok(service.findAllOrderinKitchenByID(order));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/finished")
    @Operation(summary = "Find a finished orders ", description = "Return a list of finished orders")
    public ResponseEntity<List<FoodOrderResponse>> findByCurrentDate() {
        List<OrderFood> ordersFinished = service.findbyCurrentOrderFinished();
        if(!ordersFinished.isEmpty()){
            return ResponseEntity.ok(ordersFinished.stream().map(of ->FoodOrderResponse.from(of)).toList());
        } else{
            return ResponseEntity.notFound().build();
        }
    }
}
