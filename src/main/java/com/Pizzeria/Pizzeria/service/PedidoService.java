
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.Pedido;
import java.util.List;
import java.util.Optional;


public interface PedidoService {
    
    public Pedido upsert(Pedido pedido);
    public Boolean delete(Pedido Pedido);
    public List<Pedido> findAll();
    public Optional<Pedido> findById(Integer id);
    
}
