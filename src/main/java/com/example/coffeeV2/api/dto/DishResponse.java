package com.example.coffeeV2.api.dto;

import com.example.coffeeV2.data.entity.Dish;


public class DishResponse {
    String name;
    Double price;


    public DishResponse(){

    }

    public DishResponse(String name, Double price) {
        this.name = name;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static DishResponse from(Dish dish){
        return new DishResponse(dish.getName(), dish.getPrice());
    }
}
