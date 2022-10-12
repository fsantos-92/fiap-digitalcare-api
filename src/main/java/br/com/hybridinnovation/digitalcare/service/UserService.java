package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.User;
import br.com.hybridinnovation.digitalcare.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public Page<User> listAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public void save(@Valid User user) {
        repository.save(user);
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
    
}
