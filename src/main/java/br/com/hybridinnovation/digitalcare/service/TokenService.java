package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.hybridinnovation.digitalcare.model.User;
import br.com.hybridinnovation.digitalcare.repository.UserRepository;

public class TokenService {
    @Autowired
    UserRepository repository;

    @Value("${digitalcare.jwt.secret}")
    String secret;

    public boolean validate(String token) {

        try{
            JWT.require(Algorithm.HMAC512("secret")).build().verify(token);
            return true;
        }catch(Exception e){
            return false;
        }

    }

    public Authentication getAuthenticationToken(String token) {
        String email = JWT.require(Algorithm.HMAC512("secret")).build().verify(token).getSubject();
        
        Optional<User> optional = repository.findByEmail(email);
        if (optional.isEmpty()) return null;
        var user = optional.get();
        Authentication authentication = 
                new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        
        return authentication;
    }
}
