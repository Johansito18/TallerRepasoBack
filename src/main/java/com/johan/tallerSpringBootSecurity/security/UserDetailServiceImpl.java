package com.johan.tallerSpringBootSecurity.security;

import com.johan.tallerSpringBootSecurity.model.acl.Usuario;
import com.johan.tallerSpringBootSecurity.repository.acl.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario "+email+" no existe"));
        return new UserDetailsImpl(usuario);
    }
}
