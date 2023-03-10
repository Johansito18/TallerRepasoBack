package com.johan.tallerSpringBootSecurity.dto.core;

import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class EditorialDto {

    private  Integer idEditorial;

    private String nombre;

    private List<Libro> libro;

    public EditorialDto() {
    }

    public EditorialDto(Editorial editorial) {
        this.idEditorial = editorial.getIdEditorial();
        this.nombre = editorial.getNombre();
        this.libro = editorial.getLibro();
    }

    public EditorialDto(Integer idEditorial, String nombre, List<Libro> libro) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.libro = libro;
    }
}
