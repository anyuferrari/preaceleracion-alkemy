
package com.alkemy.icons.icons.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter

public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    
    private String imagen;
    
    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;
    
    private Long superficie; //en metros cuadrados
    
    @ManyToOne()
    @JoinColumn(name = "continente_id")
    private Continente continente;
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    
    @JoinTable(
            name ="icon_pais",
            joinColumns = {@JoinColumn(name = "pais_id")},
            inverseJoinColumns = {@JoinColumn(name = "icon_id")}    )

    @JsonIgnore
    private List<Icon> icons = new ArrayList<>();

    public void addIcon(Icon icon) { this.icons.add(icon);}

}
