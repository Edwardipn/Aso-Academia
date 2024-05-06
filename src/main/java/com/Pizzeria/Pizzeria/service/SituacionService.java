
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.Situacion;
import java.util.List;
import java.util.Optional;


public interface SituacionService {
    public Situacion upsert(Situacion situacion);
    public Boolean delete(Situacion situacion);
    public List<Situacion> findAll();
    public Optional<Situacion> findById(String id);
    
    
}
