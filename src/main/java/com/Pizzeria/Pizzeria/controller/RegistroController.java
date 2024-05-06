package com.Pizzeria.Pizzeria.controller;

import com.Pizzeria.Pizzeria.advice.UsuarioNotFoundException;
import com.Pizzeria.Pizzeria.model.Acceso;
import com.Pizzeria.Pizzeria.model.Credencial;
import com.Pizzeria.Pizzeria.model.Usuario;
import com.Pizzeria.Pizzeria.service.UsuarioService;
import com.Pizzeria.Pizzeria.util.Encripta;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegistroController {

    @Autowired
    UsuarioService usuarioService;

    @PutMapping("/signup")// http://localhost:8081/register/signup ->
    /*
    body{
    "correo":"asaf.martinez@ilb.edu.mx",
    "contrasena":"asaf",
    "primerNombre":"asaf",
    "primerApellido":"martinez",
    "segundoApellido":"reyes",
    "celular":"5544332220",
    "tipoUsuario": {
        "id":"CLI",
        "description":"Cliente"
    }

}
     */
    // Definición de la función upsert que maneja la inserción o actualización de un usuario
    Usuario upsert(@RequestBody Usuario usuario) {
        // Llamada al servicio para realizar la operación de upsert
        return usuarioService.upsert(usuario);
    }

    // Controlador que maneja la autenticación de usuarios mediante un endpoint POST "/signin"
    @PostMapping("/signin") // Ejemplo de solicitud: http://localhost:8081/register/signin -> cuerpo: {"correo": "asaf.martinez@ilb.edu.mx","password": "asaf"}
    Credencial login(@RequestBody Acceso acceso) throws ServletException {
        // Verificar si el correo y la contraseña se han proporcionado
        if (acceso.getCorreo() == null || acceso.getPassword() == null) {
            throw new ServletException("Por favor capturar usuario y clave de acceso");
        }

        // Buscar al usuario en la base de datos por su correo electrónico
        Optional<Usuario> usuario = usuarioService.findOne(acceso.getCorreo());

        // Si no se encuentra al usuario, lanzar una excepción
        if (!usuario.isPresent()) {
            throw new UsuarioNotFoundException(acceso.getCorreo());
        }

        // Encriptar la contraseña proporcionada para compararla con la almacenada
        try {
            acceso.setPassword(Encripta.sha256(acceso.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            throw new ServletException("Error al encriptar la contraseña", e);
        }

        // Verificar si la contraseña encriptada coincide con la almacenada para el usuario
        if (!acceso.getPassword().equals(usuario.get().getContrasena())) {
            throw new UsuarioNotFoundException(usuario.get().getCorreo());
        }

        // Construir un objeto Credencial que contiene la información del usuario y un token JWT
        Credencial credencial = new Credencial();
        credencial.setUsuario(usuario.get());
        credencial.setToken(Jwts.builder()
                .setSubject(usuario.get().getCorreo())
                .claim("roles", "user")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretKey").compact());

        // Devolver el objeto Credencial como respuesta
        return credencial;
    }

}
