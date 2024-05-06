
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.TipoArticuloDao;
import com.Pizzeria.Pizzeria.model.TipoArticulo;
import com.Pizzeria.Pizzeria.service.TipoArticuloService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TipoArticuloServiceImpl implements TipoArticuloService{
    @Autowired
    TipoArticuloDao tipoArticuloDao;

    @Override
    public TipoArticulo upsert(TipoArticulo tipoArticulo) {
        return tipoArticuloDao.save(tipoArticulo);
        
    }

    @Override
    public Boolean delete(TipoArticulo tipoArticulo) {
        tipoArticuloDao.delete(tipoArticulo);
        Optional<TipoArticulo>tipoArticuloDelete = tipoArticuloDao.findById(tipoArticulo.getId());
        return !(tipoArticuloDelete.isPresent());
        
    }

    @Override
    public List<TipoArticulo> findAll() {
        return (List<TipoArticulo>) tipoArticuloDao.findAll();
    }

    @Override
    public Optional<TipoArticulo> findById(String id) {
        return tipoArticuloDao.findById(id);
    }
    
    
}
