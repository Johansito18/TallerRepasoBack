package com.johan.tallerSpringBootSecurity.controller.core;

import com.johan.tallerSpringBootSecurity.dto.core.EditorialDto;
import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import com.johan.tallerSpringBootSecurity.service.core.ServiceEditorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {

    @Autowired
    ServiceEditorial serviceEditorial;

    @PostMapping("/save")
    public EditorialDto saveEditorial(@RequestBody EditorialDto editorialDto){
        return serviceEditorial.SaveEditorial(editorialDto);
    }

    @GetMapping("/findById")
    public EditorialDto findById(Integer idEditorial){
        return serviceEditorial.findbyId(idEditorial);
    }

    @GetMapping("/findId")
    public boolean findId(Integer idEditorial){
        return serviceEditorial.findId(idEditorial);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Integer idEditorial){
        return serviceEditorial.deleteById(idEditorial);
    }

    @GetMapping("/findByLetra/{letra}")
    public EditorialDto findByLetra(@PathVariable String letra){
        return serviceEditorial.findByNombreStartingWith(letra);
    }


    @GetMapping("/findAll")
    public List<EditorialDto> findAll(){
        return serviceEditorial.findAll();
    }


}
