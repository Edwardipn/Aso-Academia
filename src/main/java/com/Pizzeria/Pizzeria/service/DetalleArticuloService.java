
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.DetalleArticulo;
import java.util.List;
import java.util.Optional;


public interface DetalleArticuloService {
    public DetalleArticulo upsert(DetalleArticulo detalleArticulo);
    public Boolean delete(DetalleArticulo detalleArticulo);
    public List<DetalleArticulo> findAll();
    public Optional<DetalleArticulo> findById(Integer id);
}
