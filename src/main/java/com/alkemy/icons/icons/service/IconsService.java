package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.entity.Icon;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface IconsService {
    IconsDTO save(IconsDTO dto);
    List<IconsDTO> getAllIcons();
    Icon oneIcon(Long id);
    void delete(Long id);
    List<IconsDTO> getByFilters (String name, String date, Set<Long> cities, String order);
    List<Icon> manyIcons(List<Long> ids);
    void removePais(Long id, Long idPais);
    void addPais(Long id, Long idPais);
    IconsDTO update(Long id, IconsDTO iconsDTO);
}
