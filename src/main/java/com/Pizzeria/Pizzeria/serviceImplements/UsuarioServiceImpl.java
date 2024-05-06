package com.Pizzeria.Pizzeria.serviceImplements;
import com.Pizzeria.Pizzeria.dao.UsuarioDao;
import com.Pizzeria.Pizzeria.model.Usuario;
import com.Pizzeria.Pizzeria.service.UsuarioService;
import com.Pizzeria.Pizzeria.util.Encripta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioDao usuariodao;

    @Override
    public Usuario upsert(Usuario usuario) {
        try {
            // Encriptar la contraseña del usuario utilizando SHA-256 antes de almacenarla
            usuario.setContrasena(Encripta.sha256(usuario.getContrasena()));
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción de algoritmo de hash
            throw new RuntimeException("Error al encriptar la contraseña", e);
        }

        // Guardar el usuario en la base de datos y devolver el nuevo objeto de usuario
        Usuario usuarionew = usuariodao.save(usuario);
        return usuarionew;
    }

    @Override
    public List<Usuario> findAll() {
        // Obtener todos los usuarios de la base de datos
        return (List<Usuario>) usuariodao.findAll();
    }

    @Override
    public Optional<Usuario> findOne(String correo) {
        // Buscar un usuario por su correo electrónico en la base de datos
        return usuariodao.findById(correo);
    }

    @Override
    public String delete(Usuario usuario) {
        // Eliminar un usuario de la base de datos y devolver un mensaje de éxito
        String response = "Success";
        usuariodao.delete(usuario);
        return response;
    }
}
