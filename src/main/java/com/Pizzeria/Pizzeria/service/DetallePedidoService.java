
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.DetallePedido;
import java.util.List;
import java.util.Optional;


public interface DetallePedidoService {
    public  DetallePedido upsert(DetallePedido detallePedido);
    public Boolean delete(DetallePedido detallePedido);
    public List<DetallePedido> findAll();
    public Optional<DetallePedido> findById(Integer DetallePedidoPK);
    
}
