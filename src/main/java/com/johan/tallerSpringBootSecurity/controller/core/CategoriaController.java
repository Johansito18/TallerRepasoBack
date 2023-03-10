package com.johan.tallerSpringBootSecurity.controller.core;
import com.johan.tallerSpringBootSecurity.dto.core.CategoriaDto;
import com.johan.tallerSpringBootSecurity.service.core.ServiceCategoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    ServiceCategoria serviceCategoria;

    @PostMapping("/save")
    public CategoriaDto saveCategoria(@RequestBody CategoriaDto categoriaDto){
        return serviceCategoria.saveCategoria(categoriaDto);
    }

    @GetMapping("/findById")
    public CategoriaDto findById(Integer idCategoria){
        return serviceCategoria.findById(idCategoria);
    }

    @GetMapping("/findId")
    public boolean findId(Integer idCategoria){
        return serviceCategoria.findId(idCategoria);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Integer idCategoria){
        return serviceCategoria.deleteById(idCategoria);
    }

    @GetMapping("/findAll")
    public List<CategoriaDto> findAll(){
        return serviceCategoria.findAll();
    }
}
