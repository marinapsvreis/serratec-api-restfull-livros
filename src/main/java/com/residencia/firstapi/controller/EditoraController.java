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

import com.residencia.firstapi.entity.Editora;
import com.residencia.firstapi.service.EditoraService;

@RestController
@RequestMapping("/editora")
public class EditoraController {
    @Autowired
    private EditoraService editoraService;

    @GetMapping
    public ResponseEntity<List<Editora>> findAll(){
        return ResponseEntity.ok().body(editoraService.findAll());
    }

    @GetMapping("/{editora_id}")
    public Editora findById(@PathVariable Integer editora_id){
        return editoraService.findById(editora_id);
    }
    
    @GetMapping("/nome/{editora_nome}")
    public Editora findByName(@PathVariable String editora_nome){
    	return editoraService.findByName(editora_nome);
    }

    @PostMapping
    public Editora save(@RequestBody Editora editora){
        return editoraService.save(editora);
    }

    @PutMapping("/{editora_id}")
    public Editora update(@PathVariable Integer editora_id, @RequestBody Editora editora) {
        return editoraService.update(editora, editora_id);
    }
    
    @DeleteMapping("/{editora_id}")
    public void delete(@PathVariable Integer editora_id){
        editoraService.delete(editora_id);
    }
}