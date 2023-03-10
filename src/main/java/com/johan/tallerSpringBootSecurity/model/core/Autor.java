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
@Table(name = "autores")
public class Autor implements Serializable {


    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor")
    private  Integer idAutor;

    private String nombre;

    @JsonIgnore
    @ManyToMany(mappedBy = "autor",cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"libro","autor","hibernateLazyInitializer", "handler"})
    private List<Libro> libro;


}
