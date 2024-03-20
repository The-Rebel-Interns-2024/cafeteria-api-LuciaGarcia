package com.example.coffeeV2.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.ast.Or;

@Entity
@Table(name = "orderFoodLine")
public class OrderFoodLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrderFoodLine")
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    Dish dish;

    @ManyToOne
    @JsonIgnore
    OrderFood orderFood;

    public OrderFoodLine() {
    }

    public OrderFoodLine(int quantity, Dish dish, OrderFood orderFood) {
        this.quantity = quantity;
        this.dish = dish;
        this.orderFood = orderFood;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public OrderFood getOrderFood() {
        return orderFood;
    }

    public void setOrderFood(OrderFood orderFood) {
        this.orderFood = orderFood;
    }

    @Override
    public String toString() {
        return "OrderFoodLine{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", dish=" + dish +
                ", orderFood=" + orderFood +
                '}';
    }
}
