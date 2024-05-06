package com.Pizzeria.Pizzeria.model;


// Importa las anotaciones necesarias para indicar que la clase es embebible y para definir las columnas de la clave primaria.
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

// Anotación @Embeddable indica que esta clase es embebible en otra entidad
@Embeddable
public class DetallePedidoPK implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la columna para la clave primaria, insertable = false, updatable = false indica que no se debe insertar ni actualizar este campo directamente
    @Column(insertable = false, updatable = false)
    private Integer pedido;

    // Define la columna para la clave primaria, insertable = false, updatable = false indica que no se debe insertar ni actualizar este campo directamente
    @Column(insertable = false, updatable = false)
    private Integer detalleArticulo;
}
