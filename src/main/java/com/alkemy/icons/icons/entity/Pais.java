
package com.alkemy.icons.icons.entity;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private Continente continente;
    
    /*@Column(name = "continente_id", nullable = false)
    private Long continenteId;*/
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })   
    
    @JoinTable(
            name ="icon-pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<Icon> icons = new HashSet<>();
   
}
