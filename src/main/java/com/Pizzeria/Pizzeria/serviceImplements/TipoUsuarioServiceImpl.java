
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.TipoUsuarioDAO;
import com.Pizzeria.Pizzeria.model.TipoUsuario;
import com.Pizzeria.Pizzeria.service.TipoUsuarioService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{

    @Autowired
    TipoUsuarioDAO tipoUsuariodAO;
    
    @Override
    public TipoUsuario upsert(TipoUsuario tipoUsuario) {
        return tipoUsuariodAO.save(tipoUsuario);
    }

    @Override
    public Boolean delete(TipoUsuario tipoUsuario) {
        tipoUsuariodAO.delete(tipoUsuario);
        Optional<TipoUsuario> tipousuarioDelete = tipoUsuariodAO.findById(tipoUsuario.getId());
        return !(tipousuarioDelete.isPresent());
    }

    @Override
    public List<TipoUsuario> findAll() {
        return (List<TipoUsuario>) tipoUsuariodAO.findAll();
    }

    @Override
    public Optional<TipoUsuario> findById(String id) {
        return tipoUsuariodAO.findById(id);
    }
    
}
