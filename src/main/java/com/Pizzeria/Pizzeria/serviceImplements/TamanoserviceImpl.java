
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.TamanoDao;
import com.Pizzeria.Pizzeria.model.Tamano;
import com.Pizzeria.Pizzeria.service.TamanoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class TamanoserviceImpl implements TamanoService {
    
    @Autowired
    TamanoDao tamanoDao;

    
    @Override
    public Tamano upsert(Tamano tamano) {
        return tamanoDao.save(tamano);
    }

    @Override
    public Boolean delete(Tamano tamano) {
    tamanoDao.delete(tamano);
    Optional<Tamano> tipoTamanoDelete = tamanoDao.findById(tamano.getId());
    return !(tipoTamanoDelete.isPresent()); 
    }

    @Override
    public List<Tamano> findAll() {
        return (List<Tamano>) tamanoDao.findAll();
    }

    @Override
    public Optional<Tamano> findById(String id) {
        return tamanoDao.findById(id);
    }
    
    
    
}
