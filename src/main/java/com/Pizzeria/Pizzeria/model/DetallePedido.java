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
public class DetallePedido implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Anotación @EmbeddedId indica que la clave primaria está embebida en la clase
    @EmbeddedId
    private DetallePedidoPK id;

    // Define una relación de muchos a uno con la entidad Pedido
    @ManyToOne(fetch = FetchType.EAGER)
    // Anotación @JoinColumn para mapear la columna "pedido" y especifica que no es insertable ni actualizable directamente
    @JoinColumn(name = "pedido", nullable = false, insertable = false, updatable = false)
    private Pedido pedido;

    // Define una relación de muchos a uno con la entidad TipoArticulo
    @ManyToOne(fetch = FetchType.EAGER)
    // Anotación @JoinColumn para mapear la columna "tipoArticulo" y especifica que no es insertable ni actualizable directamente
    @JoinColumn(name = "tipoArticulo", nullable = false, insertable = false, updatable = false)
    private TipoArticulo tipoArticulo;

    // Define un atributo para la cantidad
    private Integer cantidad;
}
