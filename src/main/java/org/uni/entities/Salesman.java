package org.uni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Salesman.findAll", query = "select a from Salesman as a")})
@Table(name = "salesman")
@Getter
@Setter
public class Salesman implements Serializable {
    public Salesman() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = 50)
    @Column(name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "salesman", cascade = CascadeType.ALL)
    List<Sale> sales = new ArrayList<>();
}
