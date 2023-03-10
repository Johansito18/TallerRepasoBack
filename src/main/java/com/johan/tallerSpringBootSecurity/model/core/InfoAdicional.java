package com.johan.tallerSpringBootSecurity.model.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "info_adicional")
public class InfoAdicional implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    private String idioma;

    @Column(name = "fecha_publicacion")
    private Date fechaPublicacion;

    //@JsonIgnoreProperties({"infoAdicional","hibernateLazyInitializer", "handler"})
    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "id_libro")
    private Libro libro;

    @PrePersist
    public void prePersit(){
        this.fechaPublicacion = new Date();
    }

    public InfoAdicional(Integer id, String idioma, Date fechaPublicacion) {
        this.id = id;
        this.idioma = idioma;
        this.fechaPublicacion = fechaPublicacion;
    }
}
