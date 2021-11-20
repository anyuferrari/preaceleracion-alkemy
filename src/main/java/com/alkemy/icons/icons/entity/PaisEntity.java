/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.icons.icons.entity;
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name= "pais")
@Getter
@Setter

public class PaisEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private Long id;
    
    private String imagen;
    
    @Column(name = "cant_habitantes")
    private Long cantidadHabitantes;
    
    private Long superficie; //en metros cuadrados
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continente_id", insertable = false, updatable = false)
    private ContinenteEntity continente;
    
    @Column(name = "continente_id", nullable = false)
    private Long continenteId;
    
    @ManyToMany(
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })   
    
    @JoinTable(
            name ="icon-pais",
            joinColumns = @JoinColumn(name = "pais_id"),
            inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<iconEntity> icons = new HashSet<>();
   
}
