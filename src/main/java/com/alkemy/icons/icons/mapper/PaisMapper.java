package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Continente;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.IconsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PaisMapper {
    
    @Autowired
    private ContinenteRepository continenteRepository;


    public Continente getContinenteById(Long id){
        Optional<Continente> continente = continenteRepository.findById(id);
        if(!continente.isPresent()){
            throw new ParamNotFound("Id continente invalido");
        }
        return continente.get();
    }
    @Autowired
    PaisRepository paisRepository;
    public Pais getPaisById(Long id){
        Optional<Pais> pais = paisRepository.findById(id);
        if(!pais.isPresent()){
            throw new ParamNotFound("Id pais no valido");
        }
        return pais.get();
    }



    public Pais paisDTO2Entity(PaisDTO dto){
        Pais paisEntity = new Pais();
        Continente continente = getContinenteById(dto.getContinenteId());
        paisEntity.setImagen(dto.getImagen());
        paisEntity.setCantidadHabitantes(dto.getCantidadHabitantes());
        paisEntity.setSuperficie(dto.getSuperficie());
        paisEntity.setContinente(continente);
        return paisEntity;
    }


    public Pais addIcons2Entity(Long paisId, List<Icon> iconsId){
        Pais paisEntity = getPaisById(paisId);
        paisEntity.setIcons(iconsId);
        return paisEntity;

    }
    @Autowired
    private IconsService iconsService;

    public Pais putIcons (List<Long> ids, PaisDTO dto){
        Pais paisEntity = this.paisDTO2Entity(dto);
        paisEntity.setIcons(iconsService.manyIcons(ids));
        return paisEntity;
    }
    
    @Autowired
    ContinenteMapper continenteMapper;
    @Autowired
    IconsMapper iconsMapper;
  
    public PaisDTO paisEntity2DTO (Pais entity, boolean loadIcons){
        
        PaisDTO dto = new PaisDTO();
        dto.setId(entity.getId());
        dto.setImagen(entity.getImagen());
        dto.setCantidadHabitantes(entity.getCantidadHabitantes());
        dto.setSuperficie(entity.getSuperficie());
        dto.setContinente(entity.getContinente());
        dto.setContinenteId(entity.getContinente().getId());
        if(loadIcons){
            List<IconsDTO> iconDTOS = this.iconsMapper.iconEntityList2DTOList(entity.getIcons(), false);
            dto.setIcons(iconDTOS);
        }
        return dto;
    }
    public List<PaisDTO> PaisEntityList2DTOList(List<Pais> entities, boolean loadIcons) {
        List<PaisDTO> dtos = new  ArrayList<>();
        for (Pais entity : entities) {
            dtos.add(this.paisEntity2DTO(entity, loadIcons));
        }
        return dtos;
    }
}
