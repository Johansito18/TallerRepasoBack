package com.johan.tallerSpringBootSecurity.dto.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.johan.tallerSpringBootSecurity.model.core.Categoria;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class CategoriaDto {

    private  Integer idCategoria;

    private  String nombre;

    private List<Libro> libro;

    public CategoriaDto() {
    }

    public CategoriaDto(Categoria categoria) {
        this.idCategoria = categoria.getIdCategoria();
        this.nombre = categoria.getNombre();
    }

    public CategoriaDto(Integer idCategoria, String nombre, List<Libro> libro) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
        this.libro = libro;
    }
}
