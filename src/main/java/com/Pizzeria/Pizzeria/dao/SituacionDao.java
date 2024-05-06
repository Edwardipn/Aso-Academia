
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.Situacion;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface SituacionDao extends CrudRepository<Situacion, String> {
    
}
