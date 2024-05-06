package com.Pizzeria.Pizzeria.model;

// Importa las anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
import lombok.Data;
import lombok.ToString;

// Importa las clases necesarias
import javax.persistence.*;
import java.io.Serializable;

// Anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
// Anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
@Data
@ToString
public class DetalleArticulo implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la clave primaria y utiliza GenerationType.IDENTITY para generar automáticamente valores incrementales.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Atributo para el precio del detalle del artículo
    private Double precio;

    // Define una relación de muchos a uno con la entidad Tamano
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tamano")
    private Tamano tamano;

    // Define una relación de muchos a uno con la entidad Articulo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "articulo")
    private Articulo articulo;
}
