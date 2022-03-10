package com.tavares.livrariaspring.service.impl;

import java.util.Optional;

import com.tavares.livrariaspring.model.Author;
import com.tavares.livrariaspring.model.Livro;
import com.tavares.livrariaspring.repository.AuthorRepository;
import com.tavares.livrariaspring.repository.LivroRepository;
import com.tavares.livrariaspring.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroServiceImpl implements LivroService {

    @Autowired
    LivroRepository livroRepository;    

    @Autowired
    AuthorRepository authorRepository;

    @Override
    public Iterable<Livro> buscarTodos() {
        return livroRepository.findAll();
    }

    @Override
    public Livro buscarPorId(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()) {
            return livro.get();
        } else {
            return null;
        }
    }

    @Override
    public void inserir(Livro livro) {
        Long id = livro.getAuthor().getId();
        Author autor = authorRepository.findById(id).orElseGet(() -> {
            Author novoAutor = authorRepository.save(livro.getAuthor());
            return novoAutor;
        });
        livro.setAuthor(autor);
        livroRepository.save(livro);
    }

    @Override
    public void atualizar(Long id, Livro livro) {
        
    }

    @Override
    public void deletar(Long id) {
        livroRepository.deleteById(id);        
    }
    
}
