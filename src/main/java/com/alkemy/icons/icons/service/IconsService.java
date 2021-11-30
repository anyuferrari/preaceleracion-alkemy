package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.IconsDTO;
import java.util.List;

public interface IconsService {
    IconsDTO save(IconsDTO dto);
    List<IconsDTO> getAllIcons();
    
}
