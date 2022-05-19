package com.residencia.firstapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.firstapi.entity.Autor;
import com.residencia.firstapi.service.AutorService;

@RestController
@RequestMapping("/autor")
public class AutorController {
    @Autowired
    private AutorService autorService;

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(){
        return ResponseEntity.ok().body(autorService.findAll());
    }

    @GetMapping("/{autor_id}")
    public Autor findById(@PathVariable Integer autor_id){
        return autorService.findById(autor_id);
    }
    
    @GetMapping("/nome/{autor_nome}")
    public Autor findByName(@PathVariable String autor_nome){
    	return autorService.findByName(autor_nome);
    }

    @PostMapping
    public Autor save(@RequestBody Autor autor){
        return autorService.save(autor);
    }

    @PutMapping("/{autor_id}")
    public Autor update(@PathVariable Integer autor_id, @RequestBody Autor autor) {
        return autorService.update(autor, autor_id);
    }
    
    @DeleteMapping("/{autor_id}")
    public void delete(@PathVariable Integer autor_id){
        autorService.delete(autor_id);
    }
}