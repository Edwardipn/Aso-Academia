
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.DetalleArticulo;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DetalleArticuloDao extends CrudRepository<DetalleArticulo, Integer> {
    
}
