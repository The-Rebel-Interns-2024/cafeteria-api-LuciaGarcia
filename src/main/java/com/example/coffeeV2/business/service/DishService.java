package com.example.coffeeV2.business.service;

import java.util.List;

public interface DishService<T> {
    List<T> findAll();

    List<T> findbyCurrentDateMenu();

    T findByNameDish(String name);
    T findById(Long id);
    T save(T item);
    void delete(Long id);

    boolean exist(Long id);

    void deleteAll();
}
