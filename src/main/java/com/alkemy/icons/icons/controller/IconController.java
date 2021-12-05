package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.repository.IconsRepository;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.IconsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;



@RestController
@RequestMapping("/iconos")
public class IconController {
    
    @Autowired
    private IconsService iconsService;
    
    @GetMapping
    public ResponseEntity<List<IconsDTO>> getAll() {
        List<IconsDTO> icons = iconsService.getAllIcons();
        return ResponseEntity.ok().body(icons);
       
    }
    
    @PostMapping
    public ResponseEntity<IconsDTO> save(@RequestBody IconsDTO icon) {
        IconsDTO iconoCreado = iconsService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(iconoCreado);
        
        
    }


    @GetMapping("/{id}")
    public Icon iconPorId(@PathVariable Long id){
        return iconsService.oneIcon(id);
    }
    @Autowired
    IconsRepository iconsRepository;
    public List<Icon> getIconos(List<Long> ids){
        List<Icon> result = new ArrayList<>();
        for (Long id : ids){
            Optional<Icon> icono = iconsRepository.findById(id);
            if(!icono.isPresent()){
                throw new ParamNotFound("Id Icono no valido");
            }
                result.add(icono.get());
        }
        return result;
    }
    @PutMapping("{id}")
    public ResponseEntity<IconsDTO> update(@PathVariable Long id, @RequestBody IconsDTO icon){
        IconsDTO result = this.iconsService.update(id, icon);
        return ResponseEntity.ok().body(result);
    }
    @Autowired
    PaisRepository paisRepository;


    @DeleteMapping("{id}/pais/{idPais}")
    public ResponseEntity<Void> removePais(@PathVariable Long id, @PathVariable Long idPais){
        this.iconsService.removePais(id, idPais);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.iconsService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    public ResponseEntity<List<IconsDTO>> getDetailsByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Set<Long> cities,
            @RequestParam(required = false, defaultValue = "ASC") String order
    ){
        List<IconsDTO> icons = this.iconsService.getByFilters(name,date,cities,order);
        return ResponseEntity.ok(icons);
    }
    
}
