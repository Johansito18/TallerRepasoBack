package com.johan.tallerSpringBootSecurity.model.acl;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Integer id;
    private String nombre;
    private String email;
    private String password;
}
