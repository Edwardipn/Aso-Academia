/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.DetallePedido;
import com.Pizzeria.Pizzeria.model.DetallePedidoPK;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoDao extends CrudRepository<DetallePedido, DetallePedidoPK> {

    public Optional<DetallePedido> findById(Integer DetallePedidoPK);
    
}
