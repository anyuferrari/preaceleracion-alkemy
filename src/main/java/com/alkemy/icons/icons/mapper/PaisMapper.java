package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Continente;
import com.alkemy.icons.icons.entity.Pais;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PaisMapper {
    public Pais paisDTO2Entity(PaisDTO dto){
        Pais paisEntity = new Pais();
        Continente cont = new Continente();
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setCantidadHabitantes(dto.getCantidadHabitantes());
        paisEntity.setSuperficie(dto.getSuperficie());
        return paisEntity;
    }
    public PaisDTO paisEntity2DTO (Pais entity){
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        dto.setContinente(entity.getContinente());
        
        return dto;
    }
    public List<PaisDTO> PaisEntityList2DTOList(List<Pais> entities) {
        List<PaisDTO> dtos = new  ArrayList<>();
        for (Pais entity : entities) {
            dtos.add(this.paisEntity2DTO(entity));
        }
        return dtos;
    }
    
}
