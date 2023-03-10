package com.johan.tallerSpringBootSecurity.repository.core;

import com.johan.tallerSpringBootSecurity.model.core.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface LibroRepository extends CrudRepository<Libro, Integer> {

    @Query(value = "select * from libros where titulo = ?", nativeQuery = true)
    Optional<Libro> findByTitulo(String titulo);

    Optional<Libro> findByAutor_NombreContainingIgnoreCase(String nombreAutor);

    List<Libro> findAll();


}
