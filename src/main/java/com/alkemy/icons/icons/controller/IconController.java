package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.IconsDTO;
import com.alkemy.icons.icons.service.IconsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/continentes/paises/iconos")
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
    /*
    @PutMapping("/{id}")
    public ResponseEntity<IconsDTO> update(@PathVariable Long id, @RequestBody IconsDTO icon) {
        IconsDTO result = iconsService.update(id,icon);
    }
*/
}
