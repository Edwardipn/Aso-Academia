package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.Pedido;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDao extends CrudRepository<Pedido, Integer> {

    public List<Pedido> findAllBySituacion_Id(String id);
}
