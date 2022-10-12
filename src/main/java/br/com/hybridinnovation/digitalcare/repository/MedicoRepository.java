package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
