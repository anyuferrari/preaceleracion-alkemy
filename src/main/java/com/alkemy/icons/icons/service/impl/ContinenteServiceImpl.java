package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.entity.Continente;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.ContinenteMapper;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.service.ContinenteService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContinenteServiceImpl implements ContinenteService {
    
    @Autowired
    private ContinenteMapper continenteMapper;
    @Autowired
    private ContinenteRepository continenteRepository;
    
    @Override
    public ContinenteDTO save(ContinenteDTO dto) {
        Continente entity = continenteMapper.continenteDTO2Entity(dto);
        Continente continenteCreado =  continenteRepository.save(entity);
        return continenteMapper.continenteEntity2DTO(continenteCreado);
    }

    @Override
    public List<ContinenteDTO> getAllContinentes() {
        List<Continente> entities = continenteRepository.findAll();
        return continenteMapper.continenteEntityList2DTOList(entities);
    }
    
    @Override
    public Continente oneContinente(Long id){
        Optional<Continente> result = this.continenteRepository.findById(id);
        if(!result.isPresent()){
            throw new ParamNotFound("Id continente no valido");
        }
        return result.get();
    }
}
