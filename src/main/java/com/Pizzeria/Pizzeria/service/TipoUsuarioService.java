
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.TipoUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;


public interface TipoUsuarioService {
    
    public TipoUsuario upsert(TipoUsuario tipoUsuario);
    public Boolean delete(TipoUsuario tipoUsuario);
    public List<TipoUsuario> findAll();
    public Optional<TipoUsuario> findById(String id);
    
    
    
}
