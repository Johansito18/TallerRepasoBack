package com.johan.tallerSpringBootSecurity.service.core;

import com.johan.tallerSpringBootSecurity.dto.core.EditorialDto;
import com.johan.tallerSpringBootSecurity.dto.core.InfoAdicionalDto;
import com.johan.tallerSpringBootSecurity.model.core.Editorial;
import com.johan.tallerSpringBootSecurity.model.core.InfoAdicional;
import com.johan.tallerSpringBootSecurity.repository.core.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceInfo {

    @Autowired
    InfoRepository infoRepository;

    public InfoAdicionalDto saveInfo(InfoAdicionalDto itemInfoDto){
        InfoAdicionalDto infoAdicionalDto = new InfoAdicionalDto();
        InfoAdicional infoAdicional = new InfoAdicional();
        infoAdicional.setIdioma(itemInfoDto.getIdioma());
        infoAdicional.setFechaPublicacion(itemInfoDto.getFechaPublicacion());
        infoAdicional.setLibro(itemInfoDto.getLibro());
        infoAdicional = infoRepository.save(infoAdicional);
        infoAdicionalDto = new InfoAdicionalDto(infoAdicional);
        return infoAdicionalDto;
    }

    public InfoAdicionalDto findById(Integer idInfo){
        InfoAdicionalDto infoAdicionalDto = new InfoAdicionalDto();
        Optional<InfoAdicional> infoAdicional = infoRepository.findById(idInfo);
        if (infoAdicional.isPresent()) {
            infoAdicionalDto = new InfoAdicionalDto(infoAdicional.get());
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        return infoAdicionalDto;
    }

    public boolean findId(Integer idInfo){
        return infoRepository.findById(idInfo).isPresent();

    }

    public boolean deleteById(Integer idInfo){
        try {
            Optional<InfoAdicional> infoAdicional = infoRepository.findById(idInfo);
            infoAdicional.ifPresent(value -> infoRepository.deleteById(value.getId()));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public List<InfoAdicionalDto> findAll(){
        List<InfoAdicionalDto> infoAddDtoList = new ArrayList<>();
        List<InfoAdicional> infoAddlList = infoRepository.findAll();
        for (InfoAdicional infoAdicional: infoAddlList) {
            InfoAdicionalDto itemInfoAddDto = new InfoAdicionalDto(infoAdicional);
            infoAddDtoList.add(itemInfoAddDto);
        }
        return infoAddDtoList;
    }
}
