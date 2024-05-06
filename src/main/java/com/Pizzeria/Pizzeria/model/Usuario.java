// Define el paquete para la clase
package com.Pizzeria.Pizzeria.model;

// Importa la anotación @Data de Lombok, que genera automáticamente métodos getter, setter, toString, equals y hashCode.
import lombok.Data;

// Importa las clases necesarias
import javax.persistence.*;
import java.io.Serializable;

// Anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
// Anotación @Data de Lombok genera automáticamente métodos getter, setter, toString, equals y hashCode.
@Data
public class Usuario implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la clave primaria para la entidad
    @Id
    private String correo;

    // Define atributos para el usuario
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String telefono;
    private String celular;
    private String contrasena;

    // Define una relación de muchos a uno con la entidad TipoUsuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoUsuario")
    private TipoUsuario tipoUsuario;
}
