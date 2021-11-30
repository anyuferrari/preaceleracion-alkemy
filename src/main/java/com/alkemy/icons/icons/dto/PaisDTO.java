
package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.Continente;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PaisDTO {
    private Long id;
    private String imagen;
    private Long cantidadHabitantes;
    private Long superficie;
    private Continente continente;
}
