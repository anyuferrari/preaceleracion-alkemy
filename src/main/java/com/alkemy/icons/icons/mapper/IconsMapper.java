
package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconBasicDTO;
import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Component
public class IconsMapper {
    
    @Autowired
    private PaisRepository paisRepository;
    @Autowired
    private PaisMapper paisMapper;
            
    public List<Pais> findListPaises(List<Long> ids){
        List<Pais> result = new ArrayList<>();
        for(Long id : ids){
            Optional<Pais> pais =paisRepository.findById(id);
            if(!pais.isPresent()){
                throw new ParamNotFound("Id pais no valido");
            }
            result.add(pais.get());
        }
        return result;
    }
    public List<Long> getIds(List<Pais> paises){
        List <Long> ids = new ArrayList<>();
        for (Pais pais : paises){
            ids.add(pais.getId());
        }
        return ids;
    }
    public Icon iconDTO2Entity(IconsDTO dto) {
        Icon iconEntity = new Icon();
        iconEntity.setImagen(dto.getImagen());
        iconEntity.setDenominacion(dto.getDenominacion());
        iconEntity.setAltura(dto.getAltura());
        iconEntity.setHistoria(dto.getHistoria());
        iconEntity.setFechaCreacion(dto.getFechaCreacion());
        return iconEntity;
    }
    public IconsDTO iconEntity2DTO(Icon entity, boolean loadPaises) {
    IconsDTO dto = new IconsDTO();
    dto.setId(entity.getId());
    dto.setImagen(entity.getImagen());
    dto.setDenominacion(entity.getDenominacion());
    dto.setAltura(entity.getAltura());
    //dto.setPaises(entity.getPaises());
    dto.setHistoria(entity.getHistoria());
    //dto.setPaisesId(getIds(entity.getPaises()));
    dto.setFechaCreacion(entity.getFechaCreacion());
    if(loadPaises){
        List<PaisDTO> paisesDTO = this.paisMapper.PaisEntityList2DTOList(entity.getPaises(),false);
        dto.setPaises(paisesDTO);
    }
    return dto;
    }
    public List<IconsDTO> iconEntityList2DTOList(List<Icon> entities, boolean loadIcons) {
        List<IconsDTO> dtos = new  ArrayList<>();
        for (Icon entity : entities) {
            dtos.add(this.iconEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }
    
    public List<IconBasicDTO> iconEntitySet2BasicDTOList(Collection<Icon> entities){
        List<IconBasicDTO> dtos = new ArrayList<>();
        IconBasicDTO basicDTO;
        for (Icon entity : entities){
            basicDTO = new IconBasicDTO();
            basicDTO.setId(entity.getId());
            basicDTO.setImagen(entity.getImagen());
            basicDTO.setDenominacion(entity.getDenominacion());
            dtos.add(basicDTO);
        }
        return dtos;
    }
    
    public List<IconsDTO> iconEntitySet2DTOList (Collection<Icon> entities, boolean loadPaises){
        List<IconsDTO> dtos = new ArrayList<>();
        for (Icon entity : entities){
            dtos.add(this.iconEntity2DTO(entity,loadPaises));
        }
        return dtos;
    }
}


