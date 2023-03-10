package com.johan.tallerSpringBootSecurity.service.core;

import com.johan.tallerSpringBootSecurity.dto.core.CategoriaDto;
import com.johan.tallerSpringBootSecurity.model.core.Categoria;
import com.johan.tallerSpringBootSecurity.repository.core.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCategoria {

    @Autowired
    CategoriaRepository categoriaRepository;

    public CategoriaDto saveCategoria(CategoriaDto itemCategoriaDto){
        CategoriaDto categoriaDto = new CategoriaDto();
        Categoria categoria = new Categoria();
        categoria.setNombre(itemCategoriaDto.getNombre());
        categoria.setLibro(itemCategoriaDto.getLibro());
        categoria = categoriaRepository.save(categoria);
        categoriaDto = new CategoriaDto(categoria);
        return categoriaDto;
    }

    public CategoriaDto findById(Integer idCategoria){
        CategoriaDto categoriaDto = new CategoriaDto();
        java.util.Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
        if (categoria.isPresent()) {
            categoriaDto = new CategoriaDto(categoria.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return categoriaDto;
    }

    public boolean findId(Integer idCategoria){
        return categoriaRepository.findById(idCategoria).isPresent();
    }

    public boolean deleteById(Integer idCategoria){
        try {
            java.util.Optional<Categoria> categoria = categoriaRepository.findById(idCategoria);
            categoria.ifPresent(value -> categoriaRepository.deleteById(value.getIdCategoria()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<CategoriaDto> findAll(){
        List<CategoriaDto> categoriaDtoList = new ArrayList<>();
        List<Categoria> categoriaList = categoriaRepository.findAll();
        for (Categoria categoria: categoriaList) {
            CategoriaDto itemCategoriaDto = new CategoriaDto(categoria);
            categoriaDtoList.add(itemCategoriaDto);
        }
        return categoriaDtoList;
    }

}
