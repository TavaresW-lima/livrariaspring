package com.tavares.livrariaspring.repository;

import com.tavares.livrariaspring.model.Author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
