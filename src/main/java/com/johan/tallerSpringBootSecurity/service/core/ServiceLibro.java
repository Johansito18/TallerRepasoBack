package com.johan.tallerSpringBootSecurity.service.core;

import com.johan.tallerSpringBootSecurity.dto.core.EditorialDto;
import com.johan.tallerSpringBootSecurity.dto.core.LibroDto;
import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import com.johan.tallerSpringBootSecurity.model.core.Libro;
import com.johan.tallerSpringBootSecurity.repository.core.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceLibro {

    @Autowired
    LibroRepository libroRepository;

    public LibroDto saveLibro(LibroDto itemLibroDto){
        LibroDto libroDto = new LibroDto();
        Libro libro = new Libro();
        libro.setTitulo(itemLibroDto.getTitulo());
        libro.setDescripcion(itemLibroDto.getDescripcion());
        libro.setFavorito(itemLibroDto.getFavorito());
        libro.setCategoria(itemLibroDto.getCategoria());
        libro.setEditorial(itemLibroDto.getEditorial());
        libro.setAutor(itemLibroDto.getAutor());
        libro.setInfoAdicional(itemLibroDto.getInfoAdicional());

        libro = libroRepository.save(libro);
        libroDto = new LibroDto(libro);
        return libroDto;
    }

    public LibroDto findById(Integer idLibro){
        LibroDto libroDto = new LibroDto();
        Optional<Libro> libro = libroRepository.findById(idLibro);
        if (libro.isPresent()) {
            libroDto = new LibroDto(libro.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return libroDto;
    }

    public boolean findId(Integer idLibro){
        return libroRepository.findById(idLibro).isPresent();

    }

    public LibroDto findByAutorName(String nombreAutor){
        LibroDto libroDto = new LibroDto();
        Optional<Libro> libro = libroRepository.findByAutor_NombreContainingIgnoreCase(nombreAutor);
        if (libro.isPresent()) {
            libroDto = new LibroDto(libro.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return libroDto;
    }

    public boolean deleteById(Integer idLibro){
        try {
            Optional<Libro> libro = libroRepository.findById(idLibro);
            libro.ifPresent(value -> libroRepository.deleteById(value.getIdLibro()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public LibroDto findByTitulo(String titulo){
        LibroDto libroDto = new LibroDto();
        Optional<Libro> libro = libroRepository.findByTitulo(titulo);
        if (libro.isPresent()) {
            libroDto = new LibroDto(libro.get());
            System.out.println("Libro encontrado: "+true);
        }else{
            System.out.println("Libro NO encontrado: "+false);
        }
        return libroDto;
    }

    public List<LibroDto> findAll(){
        List<LibroDto> libroDtoList = new ArrayList<>();
        List<Libro> libroList = libroRepository.findAll();
        for (Libro libro: libroList) {
            LibroDto itemLibroDto = new LibroDto(libro);
            libroDtoList.add(itemLibroDto);
        }
        return libroDtoList;
    }


}
