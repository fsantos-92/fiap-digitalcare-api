package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.User;
import br.com.hybridinnovation.digitalcare.repository.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // buscar por username
        Optional<User> user = repository.findByEmail(username);

        // se tiver retorna o usuario
        if (user.isPresent()) return user.get();

        // caso contrario, lança exp
        throw new UsernameNotFoundException("username not found " + username);

    }
    
}
