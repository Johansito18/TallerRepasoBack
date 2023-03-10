package com.johan.tallerSpringBootSecurity.controller.core;

import com.johan.tallerSpringBootSecurity.dto.core.AutorDto;
import com.johan.tallerSpringBootSecurity.model.core.Autor;
import com.johan.tallerSpringBootSecurity.service.core.ServiceAutor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    ServiceAutor serviceAutor;

    @PostMapping("/save")
    public AutorDto saveAutor(@RequestBody AutorDto autorDto){
        return serviceAutor.saveAutor(autorDto);
    }

    @GetMapping("/findById")
    public AutorDto findById(Integer idAutor){
        return serviceAutor.findById(idAutor);
    }

    @GetMapping("/findId")
    public boolean findId(Integer idAutor){
        return serviceAutor.findId(idAutor);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Integer idAutor){
        return serviceAutor.deleteById(idAutor);
    }

    @GetMapping("/findAll")
    public List<AutorDto> findAll(){
        return serviceAutor.findAll();
    }

    /*@PutMapping("/{id_autor}/libro/{libros_id}")
    public Autor asignarLibrosAutor(
            @PathVariable Integer id_autor,
            @PathVariable Integer id_libro
    ){
        return serviceAutor.asignar(id_autor, id_libro);
    }*/


}
