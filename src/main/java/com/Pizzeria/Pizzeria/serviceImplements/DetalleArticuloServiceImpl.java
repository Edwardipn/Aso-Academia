package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.DetalleArticuloDao;
import com.Pizzeria.Pizzeria.model.DetalleArticulo;
import com.Pizzeria.Pizzeria.service.DetalleArticuloService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class DetalleArticuloServiceImpl implements DetalleArticuloService{
    @Autowired
    DetalleArticuloDao detalleArticuloDao;

    @Override
    public DetalleArticulo upsert(DetalleArticulo detalleArticulo) {
        return detalleArticuloDao.save(detalleArticulo);
    }

    @Override
    public Boolean delete(DetalleArticulo detalleArticulo) {
        detalleArticuloDao.delete(detalleArticulo);
        Optional<DetalleArticulo> detalleArticuloDelete = detalleArticuloDao.findById(detalleArticulo.getId());
        return !(detalleArticuloDelete.isPresent());
    }

    @Override
    public List<DetalleArticulo> findAll() {
        return (List<DetalleArticulo>) detalleArticuloDao.findAll();
    }

    @Override
    public Optional<DetalleArticulo> findById(Integer id) {
    return detalleArticuloDao.findById(id);
    }


}