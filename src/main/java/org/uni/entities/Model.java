package org.uni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Model.findAll", query = "select a from Model as a")})
@Table(name = "model")
@Getter
@Setter
public class Model implements Serializable {
    public Model() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marque_id")
    private Marque marque;

    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL)
    List<Car> cars = new ArrayList<>();
}
