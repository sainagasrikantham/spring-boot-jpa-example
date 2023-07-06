package com.example.sb.jpa.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "cars")
public class Car {
    private Long id;
    private String make;
    private String model;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    @Column(name = "make", nullable = false)
    public String getMake() {
        return this.make;
    }

    @Column(name = "model", nullable = false)
    public String getModel() {
        return this.model;
    }

    @Override
    public String toString() {
        return "Car [id=" + this.id + ", make=" + this.make + ", model=" + model + "]";
    }
}
