package com.example.coffeeV2.api.controller;

import com.example.coffeeV2.api.dto.DishResponse;
import com.example.coffeeV2.business.service.DishService;
import com.example.coffeeV2.data.entity.Dish;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
public class DishController {

    @Autowired
    DishService<Dish> service;
    private final Logger log = LoggerFactory.getLogger(DishController.class);

    @GetMapping()
    @Operation(summary = "Find all menus", description = "Return a list of all menus")
    public ResponseEntity<List<DishResponse>> findAll() {
        List<DishResponse> allDishes = new ArrayList<>();
        List<Dish>  menus = service.findAll();
        for(Dish currentDish : menus){
            allDishes.add(DishResponse.from(currentDish));
        }
        if(!allDishes.isEmpty()){
            return ResponseEntity.ok(allDishes);
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find menu", description = "Find a menu (PK)")
    public ResponseEntity<DishResponse> findOneById(@PathVariable Long id) {
        Dish dish = service.findById(id);
        if (dish != null) {
            return ResponseEntity.ok(DishResponse.from(dish));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/name/{name}")
    @Operation(summary = "Find menu", description = "Find a menu by name")
    public ResponseEntity<DishResponse> findByName(@PathVariable String name) {
        Dish dish = service.findByNameDish(name);
        if (dish != null) {
            return ResponseEntity.ok(DishResponse.from(dish));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/today")
    @Operation(summary = "Find current date menus ", description = "Return a list of current date menus")
    public ResponseEntity<List<DishResponse>> findByCurrentDate() {
        List<DishResponse> dishesToday = new ArrayList<>();
        List<Dish> menus = service.findbyCurrentDateMenu();
        for(Dish currentDish : menus){
            dishesToday.add(DishResponse.from(currentDish));
        }
        if(!dishesToday.isEmpty()){
            return ResponseEntity.ok(dishesToday);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    @Operation(summary = "Create menu", description = "Create menu")
    public ResponseEntity<Dish> create(@RequestBody Dish dish) {
        if (dish.getId() != null) {
            log.warn("Trying to create a Menu with ID");
            return ResponseEntity.badRequest().build();
        }
        Dish result = service.save(dish);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/insert")
    public void insertDishes(){
        List<Dish> dishes= new ArrayList<Dish>();
        dishes.add(new Dish(null, LocalDate.now(),"Alubias",6.9));
        dishes.add(new Dish(null,LocalDate.now(),"Macarrones",6.9));
        dishes.add(new Dish(null,LocalDate.now(),"Sopa",6.9));
        dishes.add(new Dish(null,LocalDate.now(),"Setas",6.9));
        dishes.add(new Dish(null,LocalDate.now(),"Croquetas",6.9));
        dishes.add(new Dish(null,LocalDate.now(),"Ñoquis",6.9));
        for(Dish dish : dishes){
            service.save(dish);
        }
    }

}
