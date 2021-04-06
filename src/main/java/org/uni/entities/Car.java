package org.uni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Car.findAll", query = "select a from Car as a")})
@Table(name = "car")
@Getter
@Setter
public class Car implements Serializable {
    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Model model;

    @Column(name = "production_date")
    private Date productionDate;

    @Column(name = "power")
    private int power;

    @Column(name = "torque")
    private int torque;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Dealership> dealerships = new ArrayList<>();
}

