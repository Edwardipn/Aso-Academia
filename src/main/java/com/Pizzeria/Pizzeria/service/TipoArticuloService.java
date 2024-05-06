
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.TipoArticulo;
import java.util.List;

import java.util.Optional;


public interface TipoArticuloService {
    public TipoArticulo upsert(TipoArticulo tipoArticulo);
    public Boolean delete(TipoArticulo tipoArticulo);
    public List<TipoArticulo> findAll();
    public Optional<TipoArticulo> findById(String id);
    
    
    
}
