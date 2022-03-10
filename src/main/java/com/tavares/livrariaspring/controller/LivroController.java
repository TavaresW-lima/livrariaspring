package com.tavares.livrariaspring.controller;

import com.tavares.livrariaspring.model.Livro;
import com.tavares.livrariaspring.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livro")
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    @GetMapping
    public ResponseEntity<Iterable<Livro>> buscarTodos() {
        return ResponseEntity.ok(livroService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.buscarPorId(id));
    }

    @PostMapping()
    public ResponseEntity<Livro> inserir(@RequestBody Livro livro) {
        livroService.inserir(livro);
        return ResponseEntity.ok(livro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Livro> deletar(@PathVariable Long id) {
        livroService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
