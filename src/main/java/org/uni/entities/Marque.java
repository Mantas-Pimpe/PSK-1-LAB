package org.uni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({@NamedQuery(name = "Marque.findAll", query = "select a from Marque as a")})
@Table(name = "marque")
@Getter
@Setter
public class Marque implements Serializable {
    public Marque() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL)
    List<Model> models = new ArrayList<>();
}
