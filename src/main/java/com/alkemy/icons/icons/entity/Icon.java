
package com.alkemy.icons.icons.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter

public class Icon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;

    private String imagen;
    
    private String denominacion;
    
    @Column(name="fecha_creacion")
    @DateTimeFormat(pattern="yyy/MM/dd")
    private LocalDate fechaCreacion;
    
    private Long altura;
    
    private String historia;
    
    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<Pais> paises = new ArrayList<>();
}
