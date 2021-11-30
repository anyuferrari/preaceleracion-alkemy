package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.Pais;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IconsDTO {
    Long id;
    String imagen;
    String denominacion;
    LocalDate fechaCreacion;
    Long altura;
    String historia;
    List<Pais> paises;
    
}
