package com.example.coffeeV2.data.repository;

import com.example.coffeeV2.data.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish,Long> {
    List<Dish> findAllByDay(LocalDate date);
    Dish findByName(String name);
}
