package com.Pizzeria.Pizzeria.dao;

import com.Pizzeria.Pizzeria.model.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends CrudRepository<Usuario, String> {
    
}
