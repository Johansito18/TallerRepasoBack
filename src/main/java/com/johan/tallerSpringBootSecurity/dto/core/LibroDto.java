package com.johan.tallerSpringBootSecurity.dto.core;

import com.johan.tallerSpringBootSecurity.model.core.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


@Getter
@Setter
public class LibroDto {


    private  Integer idLibro;

    private  String titulo;

    private String descripcion;

    private Boolean favorito;

    private Categoria categoria;

    private Editorial editorial;

    private List<Autor> autor;

    private InfoAdicional infoAdicional;

    public LibroDto() {
    }

    public LibroDto(Libro libro) {
        this.idLibro = libro.getIdLibro();
        this.titulo = libro.getTitulo();
        this.descripcion = libro.getDescripcion();
        this.favorito = libro.getFavorito();
        this.categoria = libro.getCategoria();
        this.editorial = libro.getEditorial();
        this.autor = libro.getAutor();
        this.infoAdicional = libro.getInfoAdicional();
    }

    public LibroDto(Integer idLibro, String titulo, String descripcion, Boolean favorito,
                    Categoria categoria, Editorial editorial, List<Autor> autor, InfoAdicional infoAdicional) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.favorito = favorito;
        this.categoria = categoria;
        this.editorial = editorial;
        this.autor = autor;
        this.infoAdicional = infoAdicional;
    }
}

