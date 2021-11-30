package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.service.PaisService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/continentes/paises")

public class PaisController {
    
    @Autowired
    private PaisService paisService;
    
    @GetMapping
    public ResponseEntity<List<PaisDTO>> getAll() {
        List<PaisDTO> paises = paisService.getAllPaises();
        return ResponseEntity.ok().body(paises);
    }
    
    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais){
        PaisDTO paisCreado = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisCreado);
    }
    
}
