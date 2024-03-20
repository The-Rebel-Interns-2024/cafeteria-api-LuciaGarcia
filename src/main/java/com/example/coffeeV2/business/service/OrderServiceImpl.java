package com.example.coffeeV2.business.service;

import com.example.coffeeV2.api.dto.DishRequest;
import com.example.coffeeV2.api.dto.FoodOrderResponse;
import com.example.coffeeV2.data.entity.OrderFood;
import com.example.coffeeV2.data.entity.OrderFoodLine;
import com.example.coffeeV2.data.repository.DishRepository;
import com.example.coffeeV2.data.repository.OrderFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService<OrderFood> {

    @Autowired
    OrderFoodRepository repository;
    @Autowired
    DishRepository dishRepository;

    @Override
    public List<OrderFood> findAll() {
        return repository.findAll();
    }

    @Override
    public List<OrderFood> findbyCurrentOrderFinished() {
         return repository.findAllByFinished(true);
    }

    @Override
    public List<FoodOrderResponse> findAllOrderinKitchenByID(OrderFood orderFood) {
        List<FoodOrderResponse> allOrderFood = new ArrayList<>();
        List<OrderFoodLine> orderFoodLines = orderFood.getOrderFoodLineList();
        for(OrderFoodLine currentOrderFoodLine : orderFoodLines){
            FoodOrderResponse foodOrderResponse = new FoodOrderResponse(currentOrderFoodLine.getDish().getName(),currentOrderFoodLine.getQuantity());
            allOrderFood.add(foodOrderResponse);
        }
        return allOrderFood;
    }

    @Override
    public OrderFood findById(Long id) {
        OrderFood order= null;
        Optional<OrderFood> orderResult= repository.findById(id);
        if(orderResult.isPresent()){
            order = orderResult.get();
        }
        return order;
    }

    @Override
    public OrderFood save(OrderFood item) {
        List<OrderFoodLine> orderFoodLines = item.getOrderFoodLineList();
        for(OrderFoodLine orderFoodLine : orderFoodLines){
            orderFoodLine.setOrderFood(item);
        }
        return repository.save(item);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean exist(Long id) {
        return repository.existsById(id);
    }

    @Override
    public void deleteAll() {
        repository.deleteAll();
    }
}
