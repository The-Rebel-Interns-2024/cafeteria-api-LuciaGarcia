package com.example.coffeeV2.business.service;

import com.example.coffeeV2.api.dto.DishRequest;
import com.example.coffeeV2.api.dto.FoodOrderResponse;
import com.example.coffeeV2.data.entity.OrderFood;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService<T>{
    List<T> findAll();
    List<T> findbyCurrentOrderFinished();
    List<FoodOrderResponse> findAllOrderinKitchenByID(OrderFood orderFood);

    T findById(Long id);
    T save(OrderFood item);
    void delete(Long id);

    boolean exist(Long id);

    void deleteAll();
}
