package com.example.coffeeV2.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDish")
    private Long id;
    @Column(name = "Day")
    private LocalDate day;

    @Column(name="nameDish")
    private String name;

    @Column(name = "Price")
    private double price;

    @OneToMany(mappedBy = "dish",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<OrderFoodLine> orderFoodLineList;

    public Dish() {
    }

    public Dish(Long id, LocalDate day, String name, double price) {
        this.id = id;
        this.day = day;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<OrderFoodLine> getOrderFoodLineList() {
        return orderFoodLineList;
    }

    public void setOrderFoodLineList(List<OrderFoodLine> orderFoodLineList) {
        this.orderFoodLineList = orderFoodLineList;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", day=" + day +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
