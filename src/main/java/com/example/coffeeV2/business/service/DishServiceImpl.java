package com.example.coffeeV2.business.service;

import com.example.coffeeV2.data.entity.Dish;
import com.example.coffeeV2.data.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishServiceImpl implements DishService<Dish> {
    @Autowired
    private DishRepository repository;

    @Override
    public List<Dish> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Dish> findbyCurrentDateMenu() {
        return repository.findAllByDay(LocalDate.now());
    }

    @Override
    public Dish findByNameDish(String name) {
        return repository.findByName(name);
    }

    @Override
    public Dish findById(Long id) {
        Dish dish = null;
        Optional<Dish> dishResult = repository.findById(id);
        if (dishResult.isPresent()) {
            dish = dishResult.get();
        }
        return dish;
    }

    @Override
    public Dish save(Dish item) {
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
