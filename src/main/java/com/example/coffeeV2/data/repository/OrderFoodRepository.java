package com.example.coffeeV2.data.repository;

import com.example.coffeeV2.data.entity.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFoodRepository extends JpaRepository<OrderFood, Long> {
    List<OrderFood> findAllByFinished(boolean finished);
}
