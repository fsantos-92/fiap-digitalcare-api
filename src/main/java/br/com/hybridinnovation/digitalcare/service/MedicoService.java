package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Medico;
import br.com.hybridinnovation.digitalcare.repository.MedicoRepository;

@Service
public class MedicoService {
    @Autowired
    MedicoRepository repository;
    
    public Page<Medico> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Medico task) {
        repository.save(task);
    }

    public Optional<Medico> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
