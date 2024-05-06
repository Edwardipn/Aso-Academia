package com.Pizzeria.Pizzeria;

import com.Pizzeria.Pizzeria.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PizzeriaApplication {

    // Configuración de un bean para registrar el filtro JWT en la aplicación
    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        
        // Establecer el filtro JWT que se encargará de la autenticación basada en tokens
        registrationBean.setFilter(new JwtFilter());
        
        // Especificar las URL a las que se aplicará el filtro (todas las URL bajo /api/)
        registrationBean.addUrlPatterns("/api/*");

        return registrationBean;
    }
    
    // Método principal que inicia la aplicación Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(PizzeriaApplication.class, args);
    }

}
