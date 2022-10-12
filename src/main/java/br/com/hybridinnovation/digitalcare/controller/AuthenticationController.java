package br.com.hybridinnovation.digitalcare.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.hybridinnovation.digitalcare.model.JwtToken;
import br.com.hybridinnovation.digitalcare.model.User;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody User user){

        System.out.println(user.getUsername());
        try{
            Authentication authentication = 
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            authenticationManager.authenticate(authentication);

            // gerar o token
            Date issuedAt = new Date();
            Date expiresAt = new Date(issuedAt.getTime() + 60_000 );
            String token = JWT.create()
                .withSubject(user.getEmail())
                .withIssuedAt(issuedAt)
                .withExpiresAt(expiresAt)
                .sign(Algorithm.HMAC512("secret")
            );
            System.out.println(token);

            return ResponseEntity.ok(new JwtToken(token, "Bearer"));

        }catch(AuthenticationException e){
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();

    }
}
