
package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.dto.IconsFiltersDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.IconsMapper;
import com.alkemy.icons.icons.repository.IconsRepository;
import com.alkemy.icons.icons.repository.specifcations.IconSpecification;
import com.alkemy.icons.icons.service.IconsService;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class IconsServiceImpl implements IconsService {
    
    @Autowired
    private IconsMapper iconsMapper;
    @Autowired
    private IconsRepository iconsRepository;
    @Autowired
    private IconSpecification iconSpecification;
    @Autowired
    private PaisService paisService;
    
    @Override
    public IconsDTO save(IconsDTO dto) {
        Icon entity = iconsMapper.iconDTO2Entity(dto);
        Icon iconoCreado =  iconsRepository.save(entity);
        return iconsMapper.iconEntity2DTO(iconoCreado, false);
    }
    @Override
    public List<IconsDTO> getAllIcons() {
        List<Icon> entities = iconsRepository.findAll();
        return iconsMapper.iconEntityList2DTOList(entities, true);
    }
    
    @Override
    public Icon oneIcon(Long id){
        Optional<Icon> result = iconsRepository.findById(id);
        if(!result.isPresent()){
            throw new ParamNotFound("Id icono no valido");
        }
        return result.get();
    }
    @Override
    public List<Icon> manyIcons(List<Long> ids){
        List<Icon> result = new ArrayList<>();
        for (Long id : ids){
            result.add(this.oneIcon(id));
        }
        return result;
    }
    @Override
    public void delete(Long id){
        this.iconsRepository.deleteById(id);
    }
    @Override
    public void addPais(Long id, Long idPais){
        Icon entity = this.iconsRepository.getById(id);
        //entity.getPaises().size();
        Pais paisEntity = this.paisService.onePais(idPais);
        entity.addPais(paisEntity);
        this.iconsRepository.save(entity);
    }
    @Override
    public IconsDTO update (Long id, IconsDTO iconDto){
        Optional<Icon> entity = this.iconsRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id Icono no valido");
        }
        iconDto = iconsMapper.iconEntity2DTO(entity.get(), false);
        return iconDto;
    }

    @Override
    public void removePais(Long id, Long idPais){
        Icon entity = this.iconsRepository.getById(id);
        //entity.getPaises().size();
        Pais paisEntity = this.paisService.onePais(idPais);
        entity.removePais(paisEntity);
        this.iconsRepository.save(entity);
    }


    @Override
    public List<IconsDTO> getByFilters(String name, String date, Set<Long> cities, String order){
        IconsFiltersDTO filtersDTO = new IconsFiltersDTO(name,date, cities, order);
        List<Icon> entities = this.iconsRepository.findAll(this.iconSpecification.getByFilters(filtersDTO));
        return this.iconsMapper.iconEntitySet2DTOList(entities, false);
        
    }
}
