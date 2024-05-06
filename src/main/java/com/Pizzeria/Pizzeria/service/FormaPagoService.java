
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.FormaPago;
import java.util.List;
import java.util.Optional;


public interface FormaPagoService {
    public FormaPago upsert(FormaPago formapago);
    public Boolean delete(FormaPago formapago);
    public List<FormaPago> findAll();
    public Optional<FormaPago> findById(String id);
    
}
