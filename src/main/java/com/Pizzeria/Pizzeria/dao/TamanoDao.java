
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.Tamano;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TamanoDao extends CrudRepository<Tamano, String> {
    
}
