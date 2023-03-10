package com.johan.tallerSpringBootSecurity.dto.core;

import com.johan.tallerSpringBootSecurity.model.core.Autor;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AutorDto {

    private  Integer idAutor;

    private String nombre;

    private List<Libro> libro;

    public AutorDto() {
    }

    public AutorDto(Autor autor) {
        this.idAutor = autor.getIdAutor();
        this.nombre = autor.getNombre();
        this.libro = autor.getLibro();
    }

    public AutorDto(int idAutor, String nombre, List<Libro> libro) {
        this.idAutor = idAutor;
        this.nombre = nombre;
        this.libro = libro;
    }
}
