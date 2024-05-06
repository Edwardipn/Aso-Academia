
package com.Pizzeria.Pizzeria.advice;


public class UsuarioNotFoundException extends RuntimeException {

    // Constructor que toma un identificador y crea un mensaje de excepción
    public UsuarioNotFoundException(String id) {
        // Llama al constructor de la clase base (RuntimeException) con un mensaje personalizado
        super("Usuario " + id + " no encontrado");
    }
}
