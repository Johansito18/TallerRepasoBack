package com.johan.tallerSpringBootSecurity.service.core;

import com.johan.tallerSpringBootSecurity.dto.core.AutorDto;
import com.johan.tallerSpringBootSecurity.model.core.Autor;
import com.johan.tallerSpringBootSecurity.repository.core.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceAutor {

    @Autowired
    AutorRepository autorRepository;

    public AutorDto saveAutor(AutorDto itemAutorDto){
        AutorDto autorDto = new AutorDto();
        Autor autor = new Autor();
        autor.setNombre(itemAutorDto.getNombre());
        autor.setLibro(itemAutorDto.getLibro());

        autor = autorRepository.save(autor);
        autorDto = new AutorDto(autor);
        return autorDto;
    }

    public AutorDto findById(Integer idAutor){
        AutorDto autorDto = new AutorDto();
        java.util.Optional<Autor> autor = autorRepository.findById(idAutor);
        if (autor.isPresent()) {
            autorDto = new AutorDto(autor.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return autorDto;
    }


    public boolean findId(Integer idAutor){
        return autorRepository.findById(idAutor).isPresent();

    }

    public boolean deleteById(Integer idAutor){
        try {
            java.util.Optional<Autor> autor = autorRepository.findById(idAutor);
            autor.ifPresent(value -> autorRepository.deleteById(value.getIdAutor()));
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public List<AutorDto> findAll(){
        List<AutorDto> autorDtoList = new ArrayList<>();
        List<Autor> autorList = autorRepository.findAll();
        for (Autor autor: autorList) {
            AutorDto itemAutorDto = new AutorDto(autor);
            autorDtoList.add(itemAutorDto);
        }
        return autorDtoList;
    }

    /*public Autor asignar(Integer autor_id, Integer libros_id){
        List<Libro> listLibros = null;
        Autor autor = autorRepository.findById(autor_id).get();
        Libro libro = libroRepository.findById(libros_id).get();
        listLibros = autor.getLibro();
        return autorRepository.save(autor);
    }*/
}
