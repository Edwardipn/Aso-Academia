
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.DetallePedidoDao;
import com.Pizzeria.Pizzeria.model.DetallePedido;
import com.Pizzeria.Pizzeria.service.DetallePedidoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DetallePedidoImpl implements DetallePedidoService{

    @Autowired
    DetallePedidoDao detallePedidoDao;
    
    @Override
    public DetallePedido upsert(DetallePedido detallePedido) {
        return detallePedidoDao.save(detallePedido);
    }

    @Override
    public Boolean delete(DetallePedido detallePedido) {
        detallePedidoDao.delete(detallePedido);
        Optional<DetallePedido> DetallePedidoDelete = detallePedidoDao.findById(detallePedido.getId());
        return !(DetallePedidoDelete.isPresent());
    }

    @Override
    public List<DetallePedido> findAll() {
        return (List<DetallePedido>) detallePedidoDao.findAll();
    }

    @Override
    public Optional<DetallePedido> findById(Integer DetallePedidoPK) {
        return detallePedidoDao.findById(DetallePedidoPK);
    }
    
}
