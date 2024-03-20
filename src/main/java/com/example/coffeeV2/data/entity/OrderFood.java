package com.example.coffeeV2.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "orderFood")
public class OrderFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idOrderFood")
    private Long id;

    @Column(name = "Finished")
    private Boolean finished;

    @OneToMany(mappedBy = "orderFood",cascade = CascadeType.ALL)
    List<OrderFoodLine> orderFoodLineList;

    public OrderFood() {
    }

    public OrderFood(Boolean finished, List<OrderFoodLine> orderFoodLineList) {
        this.finished = finished;
        this.orderFoodLineList = orderFoodLineList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public List<OrderFoodLine> getOrderFoodLineList() {
        return orderFoodLineList;
    }

    public void setOrderFoodLineList(List<OrderFoodLine> orderFoodLineList) {
        this.orderFoodLineList = orderFoodLineList;
    }

    @Override
    public String toString() {
        return "OrderFood{" +
                "id=" + id +
                ", finished=" + finished +
                '}';
    }
}
