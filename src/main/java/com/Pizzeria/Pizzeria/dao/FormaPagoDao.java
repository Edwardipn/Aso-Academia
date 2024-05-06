
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.FormaPago;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoDao extends CrudRepository<FormaPago, String> {
    
}
