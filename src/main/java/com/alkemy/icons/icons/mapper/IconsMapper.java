
package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.entity.Icon;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class IconsMapper {
    public Icon iconDTO2Entity(IconsDTO dto) {
        Icon iconEntity = new Icon();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        iconEntity.setPaises(dto.getPaises());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        return iconEntity;
    }
    public IconsDTO iconEntity2DTO(Icon entity) {
    IconsDTO dto = new IconsDTO();
    dto.setId(entity.getId());
    dto.setImagen(entity.getImagen());
    dto.setDenominacion(entity.getDenominacion());
    dto.setAltura(entity.getAltura());
    dto.setHistoria(dto.getHistoria());
    dto.setPaises(entity.getPaises());
    dto.setFechaCreacion(entity.getFechaCreacion());
    return dto;
    }
    public List<IconsDTO> iconEntityList2DTOList(List<Icon> entities) {
        List<IconsDTO> dtos = new  ArrayList<>();
        for (Icon entity : entities) {
            dtos.add(this.iconEntity2DTO(entity));
        }
        return dtos;
    }
}
