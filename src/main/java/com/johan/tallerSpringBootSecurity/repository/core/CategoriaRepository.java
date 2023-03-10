package com.johan.tallerSpringBootSecurity.repository.core;

import com.johan.tallerSpringBootSecurity.model.core.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

    List<Categoria> findAll();
}
