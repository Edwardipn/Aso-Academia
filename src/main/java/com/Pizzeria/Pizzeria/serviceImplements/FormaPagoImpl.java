
package com.Pizzeria.Pizzeria.serviceImplements;

import com.Pizzeria.Pizzeria.dao.FormaPagoDao;
import com.Pizzeria.Pizzeria.model.FormaPago;
import com.Pizzeria.Pizzeria.service.FormaPagoService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormaPagoImpl implements FormaPagoService{
    
    @Autowired
    FormaPagoDao formaPagoDao;

    @Override
    public FormaPago upsert(FormaPago formapago) {
        return formaPagoDao.save(formapago);
    }

    @Override
    public Boolean delete(FormaPago formapago) {
        formaPagoDao.delete(formapago);
        Optional<FormaPago> FormaPagoDelete = formaPagoDao.findById(formapago.getId());
        return !(FormaPagoDelete.isPresent());
    }

    @Override
    public List<FormaPago> findAll() {
    return (List<FormaPago>) formaPagoDao.findAll();
    }

    @Override
    public Optional<FormaPago> findById(String id) {
        return formaPagoDao.findById(id);
    }
    
}
