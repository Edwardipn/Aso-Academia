
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.PedidoDao;
import com.Pizzeria.Pizzeria.model.Pedido;
import com.Pizzeria.Pizzeria.service.PedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class PedidoImpl implements PedidoService{

    @Autowired
    PedidoDao pedidoDao;
    
    @Override
    public Pedido upsert(Pedido pedido) {
        return pedidoDao.save(pedido);
    }

    @Override
    public Boolean delete(Pedido Pedido) {
    pedidoDao.delete(Pedido);
    Optional<Pedido> PedidoDelete = pedidoDao.findById(Pedido.getId());
    return !(PedidoDelete.isPresent()); 
    
    }

    @Override
    public List<Pedido> findAll() {
        return (List<Pedido>) pedidoDao.findAll();
    }

    public Optional<Pedido> findById(Integer id) {
        return pedidoDao.findById(id);
    }

    
}
