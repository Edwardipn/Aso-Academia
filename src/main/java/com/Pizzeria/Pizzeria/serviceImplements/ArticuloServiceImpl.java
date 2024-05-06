
package com.Pizzeria.Pizzeria.serviceImplements;


import com.Pizzeria.Pizzeria.dao.ArticuloDao;
import com.Pizzeria.Pizzeria.model.Articulo;
import com.Pizzeria.Pizzeria.service.ArticuloService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticuloServiceImpl implements ArticuloService {

    // Servicio que implementa operaciones relacionadas con los Articulos

    // Inyección de dependencia del DAO (Data Access Object) de Articulos
    @Autowired
    ArticuloDao ArticuloDao;

    // Método para agregar o actualizar un Articulo
    @Override
    public Articulo upsert(Articulo articulo) {
        return ArticuloDao.save(articulo);
    }

    // Método para eliminar un Articulo
    @Override
    public Boolean delete(Articulo articulo) {
        // Eliminar el Articulo de la base de datos
        ArticuloDao.delete(articulo);

        // Verificar si el Articulo fue eliminado correctamente
        Optional<Articulo> ArticuloDelete = ArticuloDao.findById(articulo.getId());
        return !(ArticuloDelete.isPresent());
    }

    // Método para obtener todos los Articulos
    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) ArticuloDao.findAll();
    }

    // Método para encontrar un Articulo por su ID
    @Override
    public Optional<Articulo> findById(String id) {
        return ArticuloDao.findById(id);
    }
}
