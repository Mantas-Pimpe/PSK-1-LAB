package org.uni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
@NamedQueries({@NamedQuery(name = "Sale.findAll", query = "select a from Sale as a")})
@Table(name = "sale")
@Getter
@Setter
public class Sale implements Serializable {
    public Sale() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sale_date")
    private Date saleDate;

    @Column(name = "price")
    private Double price;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dealership_id")
    private Dealership dealership;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "model_id")
    private Model model;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesman_id")
    private Salesman salesman;
}
