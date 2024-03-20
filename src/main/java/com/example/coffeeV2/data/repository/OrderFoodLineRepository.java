package com.example.coffeeV2.data.repository;

import com.example.coffeeV2.data.entity.OrderFood;
import com.example.coffeeV2.data.entity.OrderFoodLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderFoodLineRepository extends JpaRepository<OrderFoodLine,Long> {
}
