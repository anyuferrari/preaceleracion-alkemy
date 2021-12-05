package com.alkemy.icons.icons.controller;


import com.alkemy.icons.icons.dto.PaisDTO;
import com.alkemy.icons.icons.entity.Continente;
import com.alkemy.icons.icons.entity.Icon;
import com.alkemy.icons.icons.entity.Pais;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.repository.ContinenteRepository;
import com.alkemy.icons.icons.repository.IconsRepository;
import com.alkemy.icons.icons.repository.PaisRepository;
import com.alkemy.icons.icons.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/paises")

public class PaisController {
    
    @Autowired
    private PaisService paisService;
    
    @GetMapping
    public ResponseEntity<List<PaisDTO>> getAll() {
        List<PaisDTO> paises = paisService.getAllPaises();
        return ResponseEntity.ok().body(paises);
    }
    @GetMapping("/{id}")
    public Pais paisPorId(@PathVariable Long id){
        return paisService.onePais(id);
    }
    
    @PostMapping
    public ResponseEntity<PaisDTO> save(@RequestBody PaisDTO pais){
        PaisDTO paisCreado = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(paisCreado);
    }
    @Autowired
    ContinenteRepository continenteRepository;
    
    @GetMapping("/continentes/{id}")
    public Continente getContinenteById(@PathVariable Long id){
        Optional<Continente> continente = continenteRepository.findById(id);
        if(!continente.isPresent()){
            throw new ParamNotFound("Id continente not found");
        }
        return continente.get();
    }

    @Autowired
    private IconsRepository iconsRepository;
    @Autowired
    private PaisRepository paisRepository;
    @PutMapping("{idPais}/icon/{idIcono}")
    public Pais addIcon(@PathVariable Long idIcono, @PathVariable Long idPais){
        Optional<Icon> icon = iconsRepository.findById(idIcono);
        Optional<Pais> pais = paisRepository.findById(idPais);
        if(!icon.isPresent()){
            throw new ParamNotFound("Id icono no valido");
        }
        if(!pais.isPresent()){
            throw new ParamNotFound("Id pais no valido");
        }
        Pais paisEntity = pais.get();
        paisEntity.addIcon(icon.get());
        return paisRepository.save(pais.get());
    }

}
