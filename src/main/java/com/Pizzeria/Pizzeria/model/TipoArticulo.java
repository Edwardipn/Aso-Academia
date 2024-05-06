package com.Pizzeria.Pizzeria.model;

// Importa las anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
import lombok.Data;
import lombok.ToString;

// Importa las clases necesarias
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

// Anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
// Anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
@Data
@ToString
public class TipoArticulo implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la clave primaria para la entidad
    @Id
    private String id;

    // Define el atributo para la descripción del tipo de artículo
    private String descripcion;
}
