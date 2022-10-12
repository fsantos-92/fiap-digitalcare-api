package br.com.hybridinnovation.digitalcare.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.hybridinnovation.digitalcare.model.SintomaAtendimento;
import br.com.hybridinnovation.digitalcare.repository.SintomaAtendimentoRepository;

@Service
public class SintomaAtendimentoService {
    @Autowired
    SintomaAtendimentoRepository repository;
    
    public Page<SintomaAtendimento> listAll(Pageable pageable){
       return repository.findAll(pageable);
    }

    public void save(SintomaAtendimento task) {
        repository.save(task);
    }

    public Optional<SintomaAtendimento> getById(Long id) {
        return repository.findById(id);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
