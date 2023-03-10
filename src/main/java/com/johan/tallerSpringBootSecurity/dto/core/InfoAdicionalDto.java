package com.johan.tallerSpringBootSecurity.dto.core;

import com.johan.tallerSpringBootSecurity.model.core.InfoAdicional;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class InfoAdicionalDto {

    private  Integer id;

    private String idioma;

    private Date fechaPublicacion;

    private Libro libro;

    @PrePersist
    public void prePersit(){
        this.fechaPublicacion = new Date();
    }

    public InfoAdicionalDto() {
    }

    public InfoAdicionalDto(InfoAdicional infoAdicional) {
        this.id = infoAdicional.getId();
        this.idioma = infoAdicional.getIdioma();
        this.fechaPublicacion = infoAdicional.getFechaPublicacion();
        this.libro = infoAdicional.getLibro();
    }

    public InfoAdicionalDto(Integer id, String idioma, Date fechaPublicacion, Libro libro) {
        this.id = id;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicacion;
        this.libro = libro;
    }
}
