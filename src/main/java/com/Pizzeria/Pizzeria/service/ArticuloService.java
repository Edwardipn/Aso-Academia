
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.Articulo;
import java.util.List;
import java.util.Optional;


public interface ArticuloService {
    public Articulo upsert(Articulo articulo);
    public Boolean delete(Articulo articulo);
    public List<Articulo> findAll();
    public Optional<Articulo> findById(String id);
}
