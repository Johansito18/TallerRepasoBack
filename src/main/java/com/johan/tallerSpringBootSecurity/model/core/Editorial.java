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
@Table(name = "editoriales")
public class Editorial implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_editorial")
    private  Integer idEditorial;

    private String nombre;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "editorial")
    private List<Libro> libro;


}
