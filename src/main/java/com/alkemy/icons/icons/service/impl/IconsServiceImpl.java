
package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.mapper.IconsMapper;
import com.alkemy.icons.icons.repository.IconsRepository;
import com.alkemy.icons.icons.service.IconsService;
import java.util.List;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class IconsServiceImpl implements IconsService {
    
    @Autowired
    private IconsMapper iconsMapper;
    @Autowired
    private IconsRepository iconsRepository;
    
    public IconsDTO save(IconsDTO dto) {
        Icon entity = iconsMapper.iconDTO2Entity(dto);
        Icon iconoCreado =  iconsRepository.save(entity);
        IconsDTO result = iconsMapper.iconEntity2DTO(iconoCreado);
        return result;
    }
    public List<IconsDTO> getAllIcons() {
        List<Icon> entities = iconsRepository.findAll();
        List<IconsDTO> result = iconsMapper.iconEntityList2DTOList(entities);
        return result;
    }
    

}
