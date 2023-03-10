package com.johan.tallerSpringBootSecurity.service.core;

import com.johan.tallerSpringBootSecurity.dto.core.AutorDto;
import com.johan.tallerSpringBootSecurity.dto.core.EditorialDto;
import com.johan.tallerSpringBootSecurity.model.core.Autor;
import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import com.johan.tallerSpringBootSecurity.repository.core.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceEditorial {

    @Autowired
    EditorialRepository editorialRepository;

    public EditorialDto SaveEditorial(EditorialDto itemEditorialDto){
        EditorialDto editorialDto = new EditorialDto();
        Editorial editorial = new Editorial();
        editorial.setNombre(itemEditorialDto.getNombre());
        editorial.setLibro(itemEditorialDto.getLibro());
        editorial = editorialRepository.save(editorial);
        editorialDto = new EditorialDto(editorial);
        return editorialDto;
    }

    public EditorialDto findbyId(Integer idEditorial){
        EditorialDto editorialDto = new EditorialDto();
        Optional<Editorial> editorial = editorialRepository.findById(idEditorial);
        if (editorial.isPresent()) {
            editorialDto = new EditorialDto(editorial.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return editorialDto;
    }

    public boolean findId(Integer idEditorial){
        return editorialRepository.findById(idEditorial).isPresent();
    }

    public boolean deleteById(Integer idEditorial){
        try {
            Optional<Editorial> editorial = editorialRepository.findById(idEditorial);
            editorial.ifPresent(value -> editorialRepository.deleteById(value.getIdEditorial()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public EditorialDto findByNombreStartingWith(String letra){

        EditorialDto editorialDto = new EditorialDto();
        Optional<Editorial> editorial = editorialRepository.findByNombreStartingWith(letra);
        if (editorial.isPresent()) {
            editorialDto = new EditorialDto(editorial.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return editorialDto;
    }

    public List<EditorialDto> findAll(){
        List<EditorialDto> editorialDtoList = new ArrayList<>();
        List<Editorial> editorialList = editorialRepository.findAll();
        for (Editorial editorial: editorialList) {
            EditorialDto itemEditorialDto = new EditorialDto(editorial);
            editorialDtoList.add(itemEditorialDto);
        }
        return editorialDtoList;
    }
}
