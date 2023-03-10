package com.johan.tallerSpringBootSecurity.repository.acl;

import com.johan.tallerSpringBootSecurity.model.acl.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findOneByEmail(String email);
}
