package com.Pizzeria.Pizzeria.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.GenericFilterBean;

public class JwtFilter extends GenericFilterBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // Convertir las solicitudes y respuestas a tipos específicos de HTTP
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse)  servletResponse;

        // Obtener el encabezado de autorización de la solicitud
        final String authHeader = request.getHeader("authorization");

        // Manejar solicitudes OPTIONS (usadas en CORS)
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            // Verificar la presencia y formato correcto del encabezado de autorización
            if(authHeader == null || !authHeader.startsWith("Bearer ")) {
                throw new ServletException("Se olvidó colocar el Authorization Bearer");
            }

            // Extraer el token de autorización del encabezado
            final String token = authHeader.substring(7);
            
            // Imprimir el token en el registro
            LOGGER.info("***** TOKEN:".concat(token));

            // Verificar la validez del token utilizando la biblioteca Json Web Token (JWT)
            try {
                final Claims claims = Jwts.parser().setSigningKey("secretKey").parseClaimsJws(token).getBody();
                
                // Agregar los reclamos del token a la solicitud para su uso posterior
                request.setAttribute("claims", claims);
            } catch (SignatureException se) {
                // Lanzar una excepción si el token es inválido
                throw new ServletException("Token Inválido");
            }

            // Continuar con la cadena de filtros
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
