
package com.Pizzeria.Pizzeria.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class UsuarioNotFoundAdvice {

    // Este método maneja las excepciones de tipo UsuarioNotFoundException
    @ResponseBody
    @ExceptionHandler(UsuarioNotFoundException.class)
    
    // Devuelve un código de estado HTTP 404 (NOT_FOUND) en caso de excepción
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String usuarioNotFoundHandler(UsuarioNotFoundException ex) {
        // Retorna el mensaje de la excepción como cuerpo de la respuesta
        return ex.getMessage();
    }
}
