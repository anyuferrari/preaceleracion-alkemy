package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinenteDTO;
import com.alkemy.icons.icons.service.ContinenteService;
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
@RequestMapping("/continentes")
public class ContinenteController {
    
    @Autowired    
    private ContinenteService continenteService;
    
    @GetMapping
    public ResponseEntity<List<ContinenteDTO>> getAll() {
        List<ContinenteDTO> continentes = continenteService.getAllContinentes();
        return ResponseEntity.ok().body(continentes);
    }
    
    @PostMapping
    public ResponseEntity<ContinenteDTO> save(@RequestBody ContinenteDTO continente) {
        ContinenteDTO continenteCreado = continenteService.save(continente);
        return ResponseEntity.status(HttpStatus.CREATED).body(continenteCreado);
        
        
    }
    
}
