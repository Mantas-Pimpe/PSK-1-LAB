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
@NamedQueries({@NamedQuery(name = "Dealership.findAll", query = "select a from Dealership as a")})
@Table(name = "dealership")
@Getter
@Setter
public class Dealership implements Serializable {
    public Dealership() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @Size(max = 50)
    @Column(name = "location")
    private String location;

    @ManyToMany(cascade = CascadeType.ALL)
    List<Car> cars = new ArrayList<>();

    @OneToMany(mappedBy = "dealership", cascade = CascadeType.ALL)
    List<Sale> sales = new ArrayList<>();
}
