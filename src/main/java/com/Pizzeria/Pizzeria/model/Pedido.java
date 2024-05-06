package com.Pizzeria.Pizzeria.model;

// Importa las anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
import lombok.Data;
import lombok.ToString;

// Importa las clases necesarias
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// Anotación @Entity indica que esta clase es una entidad persistente en la base de datos
@Entity
// Anotaciones de Lombok para generar automáticamente los métodos getter, setter y toString.
@Data
@ToString
public class Pedido implements Serializable {

    // Define la clave primaria para la entidad y utiliza GenerationType.IDENTITY para generar automáticamente valores incrementales.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // Anotación @Temporal se utiliza para mapear un campo de tipo java.util.Date o java.util.Calendar
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    // Define una relación de muchos a uno con la entidad FormaPago
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "formaPago")
    private FormaPago formaPago;

    // Anotación @Temporal para mapear la fecha de pago
    @Temporal(TemporalType.DATE)
    private Date fechaPago;

    // Atributos para el total, referencia y situación del pedido
    private Double total;
    private String referencia;

    // Define una relación de muchos a uno con la entidad Situacion
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "situacion")
    private Situacion situacion;

    // Define una relación de muchos a uno con la entidad Usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario")
    private Usuario usuario;
}
