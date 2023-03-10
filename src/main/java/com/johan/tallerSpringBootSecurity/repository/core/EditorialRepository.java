package com.johan.tallerSpringBootSecurity.repository.core;

import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EditorialRepository extends CrudRepository<Editorial, Integer> {

    //@Query(value = "SELECT * FROM editoriales WHERE nombre LIKE '?%'", nativeQuery = true)
    Optional<Editorial> findByNombreStartingWith(String letra);

    List<Editorial> findAll();
}
