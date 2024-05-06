
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.Tamano;
import java.util.List;
import java.util.Optional;


public interface TamanoService {
    public Tamano upsert(Tamano tamano);
    public Boolean delete(Tamano Tamano);
    public List<Tamano> findAll();
    public Optional<Tamano> findById(String id);
    
    
}
