package com.johan.tallerSpringBootSecurity.repository.core;

import com.johan.tallerSpringBootSecurity.model.core.InfoAdicional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InfoRepository extends CrudRepository<InfoAdicional, Integer> {

    List<InfoAdicional> findAll();
}
