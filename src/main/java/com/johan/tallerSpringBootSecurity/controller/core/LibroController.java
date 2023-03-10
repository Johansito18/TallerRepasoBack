package com.johan.tallerSpringBootSecurity.controller.core;

import com.johan.tallerSpringBootSecurity.dto.core.LibroDto;
import com.johan.tallerSpringBootSecurity.model.core.Autor;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import com.johan.tallerSpringBootSecurity.service.core.ServiceLibro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    ServiceLibro serviceLibro;

    @PostMapping("/save")
    public LibroDto saveLibro(@RequestBody LibroDto libroDto){
        return serviceLibro.saveLibro(libroDto);
    }

    @GetMapping("/findById")
    public LibroDto findById(Integer idLibro){
        return serviceLibro.findById(idLibro);
    }

    @GetMapping("/findId")
    public boolean findId(Integer idLibro){
        return serviceLibro.findId(idLibro);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Integer idLibro){
        return serviceLibro.deleteById(idLibro);
    }

    @GetMapping("/findByNombre")
    public LibroDto findByTitulo(String titulo){
        return serviceLibro.findByTitulo(titulo);
    }

    @GetMapping("/findByNombreAutor/{nombreAutor}")
    public LibroDto findByAutorName(@PathVariable String nombreAutor){
        return serviceLibro.findByAutorName(nombreAutor);
    }

    @GetMapping("/findAll")
    public List<LibroDto> findAll(){
        return serviceLibro.findAll();
    }


}
