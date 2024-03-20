package com.example.coffeeV2.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "dish")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
}
