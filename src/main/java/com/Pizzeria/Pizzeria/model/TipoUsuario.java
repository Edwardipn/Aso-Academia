// Define el paquete para la clase
package com.Pizzeria.Pizzeria.model;

// Importa las anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Importa las clases necesarias
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

// Anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
// Anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
@Getter
@Setter
@ToString
public class TipoUsuario implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la clave primaria para la entidad
    @Id
    private String id;

    // Define el atributo para la descripción del tipo de usuario
    private String descripcion;
}
