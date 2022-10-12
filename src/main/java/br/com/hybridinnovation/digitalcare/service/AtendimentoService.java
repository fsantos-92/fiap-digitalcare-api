package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.Atendimento;
import br.com.hybridinnovation.digitalcare.repository.AtendimentoRepository;

@Service
public class AtendimentoService {
    @Autowired
    AtendimentoRepository repository;
    
    public Page<Atendimento> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(Atendimento task) {
        repository.save(task);
    }

    public Optional<Atendimento> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
