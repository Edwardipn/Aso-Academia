
package com.Pizzeria.Pizzeria.service;

import com.Pizzeria.Pizzeria.model.Usuario;
import java.util.List;
import java.util.Optional;


public interface UsuarioService {
  
   // CRUD: Create  Read  Update Delete
    public  Usuario upsert ( Usuario usuario);

    public List<Usuario> findAll();

    public Optional<Usuario> findOne(String correo);

    public String delete(Usuario usuario);
 
    
    
}
