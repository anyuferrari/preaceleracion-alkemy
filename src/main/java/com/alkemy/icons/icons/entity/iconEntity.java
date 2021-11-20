/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alkemy.icons.icons.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name= "icon")
@Getter
@Setter

public class iconEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    
    private Long id;

    private String imagen;
    
    private String denominacion;
    
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern="yyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long altura;
    
    private String historia;
    
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<PaisEntity> paises = new ArrayList<>();
}
