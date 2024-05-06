package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.TipoUsuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioDAO extends CrudRepository<TipoUsuario,String> {
    
}
