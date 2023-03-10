package com.johan.tallerSpringBootSecurity.model.core;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "libros")
public class Libro implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro")
    private  Integer idLibro;

    private  String titulo;

    private String descripcion;

    private Boolean favorito;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_editorial")
    private Editorial editorial;

    @JsonIgnore
    @JsonIgnoreProperties({"autor","libro","hibernateLazyInitializer", "handler"})
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinTable(name = "autor_libro",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    private List<Autor> autor;

    @JsonIgnore
    @OneToOne(mappedBy = "libro", cascade = CascadeType.ALL)
    private InfoAdicional infoAdicional;

}

