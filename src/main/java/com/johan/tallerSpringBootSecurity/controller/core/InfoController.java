package com.johan.tallerSpringBootSecurity.controller.core;

import com.johan.tallerSpringBootSecurity.dto.core.InfoAdicionalDto;
import com.johan.tallerSpringBootSecurity.model.core.InfoAdicional;
import com.johan.tallerSpringBootSecurity.service.core.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    ServiceInfo serviceInfo;

    @PostMapping("/save")
    public InfoAdicionalDto saveInfo(@RequestBody InfoAdicionalDto infoDto){
        return serviceInfo.saveInfo(infoDto);
    }

    @GetMapping("/findById")
    public InfoAdicionalDto findById(Integer idInfo){
        return serviceInfo.findById(idInfo);
    }

    @GetMapping("/findId")
    public boolean findId(Integer idInfo){
        return serviceInfo.findId(idInfo);
    }

    @DeleteMapping("/deleteById")
    public boolean deleteById(Integer idInfo){
        return serviceInfo.deleteById(idInfo);
    }

    @GetMapping("/findAll")
    public List<InfoAdicionalDto> findAll(){
        return serviceInfo.findAll();
    }


}
