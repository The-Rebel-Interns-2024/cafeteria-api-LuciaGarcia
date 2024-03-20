package com.example.coffeeV2.api.dto;

import com.example.coffeeV2.data.entity.OrderFood;
import com.example.coffeeV2.data.entity.OrderFoodLine;
import org.hibernate.query.Order;

import java.util.List;

public class FoodOrderResponse {

    private String nameDish;

    private Integer quantity;

    public FoodOrderResponse(String nameDish, Integer quantity) {
        this.nameDish = nameDish;
        this.quantity = quantity;
    }


    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static FoodOrderResponse from(OrderFood order){
        List<OrderFoodLine> orders = order.getOrderFoodLineList();
        String name= null;
        Integer quantity = null;
        for(OrderFoodLine currentFoodOrder : orders){
            name =currentFoodOrder.getDish().getName();
            quantity = currentFoodOrder.getQuantity();
        }
       return new FoodOrderResponse(
               name,
               quantity
              );
    }
}
