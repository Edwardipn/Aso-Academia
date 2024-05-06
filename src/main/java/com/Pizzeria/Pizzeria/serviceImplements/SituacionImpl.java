
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.SituacionDao;
import com.Pizzeria.Pizzeria.model.Situacion;
import com.Pizzeria.Pizzeria.service.SituacionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class SituacionImpl implements SituacionService{

    @Autowired
    SituacionDao situacionDao;
    
    @Override
    public Situacion upsert(Situacion situacion) {
        return situacionDao.save(situacion);
    }

    @Override
    public Boolean delete(Situacion situacion) {
        situacionDao.delete(situacion);
        Optional<Situacion> situacionDelete = situacionDao.findById(situacion.getId());
        return !(situacionDelete.isPresent());
    }

    @Override
    public List<Situacion> findAll() {
        return (List<Situacion>) situacionDao.findAll();
    }

    @Override
    public Optional<Situacion> findById(String id) {
        return situacionDao.findById(id);
    }
    
}
