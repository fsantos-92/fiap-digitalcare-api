package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Contatos;
import br.com.hybridinnovation.digitalcare.repository.ContatosRepository;

@Service
public class ContatosService {
    @Autowired
    ContatosRepository repository;
    
    public Page<Contatos> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Contatos task) {
        repository.save(task);
    }

    public Optional<Contatos> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
