package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Sintoma;
import br.com.hybridinnovation.digitalcare.repository.SintomaRepository;

@Service
public class SintomaService {
    @Autowired
    SintomaRepository repository;
    
    public Page<Sintoma> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Sintoma task) {
        repository.save(task);
    }

    public Optional<Sintoma> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
