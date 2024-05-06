package com.Pizzeria.Pizzeria.controller;

import com.Pizzeria.Pizzeria.model.TipoUsuario;
import com.Pizzeria.Pizzeria.service.TipoUsuarioService;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TipoUsuarioController {

    @Autowired
    TipoUsuarioService tipoUsuarioService;

    @PostMapping("/tipo-usuario")//->http://localhost:8081/api/tipo-usuario/PIZ
    TipoUsuario upsert(@RequestBody TipoUsuario tipoUsuario) throws ServletException {
        tipoUsuario = tipoUsuarioService.upsert(tipoUsuario);
        if (tipoUsuario == null) {
            throw new ServletException("Operacion no exitosa");
        }
        return tipoUsuario;
    }
    
    @GetMapping("/tipo-usuario/{id}")//->http://localhost:8081/api/tipo-usuario
    TipoUsuario fidById(@PathVariable String id){
    Optional<TipoUsuario> tipoUsuario = tipoUsuarioService.findById(id);
    return tipoUsuario.get();
    }
    
    @DeleteMapping("/tipo-usuario")//->http://localhost:8081/api/tipo-usuario
    Boolean delete(@RequestBody TipoUsuario tipoUsuario){
    return tipoUsuarioService.delete(tipoUsuario);
    }
    
    @GetMapping("tipo-usuario")//->http://localhost:8081/api/tipo-usuario
    List<TipoUsuario> findAll(){
    return tipoUsuarioService.findAll();
    }
}
