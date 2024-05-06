
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.TipoArticulo;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface TipoArticuloDao extends CrudRepository<TipoArticulo, String> {
    
}
