package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Endereco;
import br.com.hybridinnovation.digitalcare.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository repository;
    
    public Page<Endereco> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Endereco task) {
        repository.save(task);
    }

    public Optional<Endereco> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
