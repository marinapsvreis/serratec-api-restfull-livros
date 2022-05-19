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

import com.residencia.firstapi.entity.Livro;
import com.residencia.firstapi.service.LivroService;

@RestController
@RequestMapping("/livro")
public class LivroController {
    @Autowired
    private LivroService livroService;
    
    @GetMapping
    public ResponseEntity<List<Livro>> findAll(){
        return ResponseEntity.ok().body(livroService.findAll());
    }

    @GetMapping("/{livro_id}")
    public Livro findById(@PathVariable Integer livro_id){
        return livroService.findById(livro_id);
    }
    
    @GetMapping("/nome/{livro_nome}")
    public Livro findByName(@PathVariable String livro_nome){
    	return livroService.findByName(livro_nome);
    }

    @PostMapping
    public Livro save(@RequestBody Livro livro){
        return livroService.save(livro);
    }

    @PutMapping("/{livro_id}")
    public Livro update(@PathVariable Integer livro_id, @RequestBody Livro livro) {
        return livroService.update(livro, livro_id);
    }
    
    @DeleteMapping("/{livro_id}")
    public void delete(@PathVariable Integer livro_id){
        livroService.delete(livro_id);
    }
}