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
public class Articulo implements Serializable {

    // Define una constante para la serialización
    private static final long SerialVersionUID = 1L;

    // Define la clave primaria para la entidad
    @Id
    private String id;

    // Atributos para el nombre, ingredientes y estado de vigencia del artículo
    private String nombre;
    private String ingredientes;
    private Integer vigente;

    // Define una relación de muchos a uno con la entidad TipoArticulo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipoArticulo")
    private TipoArticulo tipoArticulo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(String ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Integer getVigente() {
		return vigente;
	}

	public void setVigente(Integer vigente) {
		this.vigente = vigente;
	}

	public TipoArticulo getTipoArticulo() {
		return tipoArticulo;
	}

	public void setTipoArticulo(TipoArticulo tipoArticulo) {
		this.tipoArticulo = tipoArticulo;
	}

	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
    
    
}
