package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.mapper.PaisMapper;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl implements PaisService {
    @Autowired
    private PaisMapper paisMapper;
    @Autowired
    private PaisRepository paisRepository;
    
    public PaisDTO save(PaisDTO dto){
        Pais entity = paisMapper.paisDTO2Entity(dto);
        Pais paisCreado = paisRepository.save(entity);
        PaisDTO result = paisMapper.paisEntity2DTO(paisCreado);
        return result;
    }

    @Override
    public List<PaisDTO> getAllPaises() {
        List<Pais> entities = paisRepository.findAll();
        List<PaisDTO> result = paisMapper.PaisEntityList2DTOList(entities);
        return result; 
    }
}
