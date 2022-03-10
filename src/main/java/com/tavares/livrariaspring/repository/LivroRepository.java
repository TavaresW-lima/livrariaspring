package com.tavares.livrariaspring.repository;

import com.tavares.livrariaspring.model.Livro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends CrudRepository<Livro, Long> {
}
