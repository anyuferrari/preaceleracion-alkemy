package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class IconsDTO {
    Long id;
    String imagen;
    String denominacion;
    LocalDate fechaCreacion;
    Long altura;
    String historia;
    List<PaisDTO> paises;
}
