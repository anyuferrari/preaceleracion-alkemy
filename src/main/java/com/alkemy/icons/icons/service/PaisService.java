package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.PaisDTO;
import java.util.List;

public interface PaisService {
    
    PaisDTO save(PaisDTO dto);
    List<PaisDTO> getAllPaises();
    
    
}
