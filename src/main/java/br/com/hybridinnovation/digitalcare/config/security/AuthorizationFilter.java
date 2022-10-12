package br.com.hybridinnovation.digitalcare.config.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.hybridinnovation.digitalcare.service.TokenService;

public class AuthorizationFilter extends OncePerRequestFilter{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                String header = request.getHeader("Authorization");

                // validar o token
                if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) return;
                var service = new TokenService();
                String token = header.substring(7);
        
                if (service.validate(token)){
                    SecurityContextHolder.getContext().setAuthentication(service.getAuthenticationToken(token));
                }
        
        
                filterChain.doFilter(request, response);
    }
    
}
