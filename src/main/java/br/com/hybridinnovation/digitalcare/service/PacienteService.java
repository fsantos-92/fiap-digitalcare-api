package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Paciente;
import br.com.hybridinnovation.digitalcare.repository.PacienteRepository;

@Service
public class PacienteService {
    @Autowired
    PacienteRepository repository;
    
    public Page<Paciente> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Paciente task) {
        repository.save(task);
    }

    public Optional<Paciente> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
