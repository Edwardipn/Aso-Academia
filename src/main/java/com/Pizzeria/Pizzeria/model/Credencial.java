
package com.Pizzeria.Pizzeria.model;

import java.io.Serializable;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Credencial implements Serializable {
    private static final long SerialVersionUID = 1L;
    
    private Usuario usuario;
    private String token;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public static long getSerialversionuid() {
		return SerialVersionUID;
	}
    
    
    
}
