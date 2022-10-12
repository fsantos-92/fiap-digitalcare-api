package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Sintoma;

public interface SintomaRepository extends JpaRepository<Sintoma, Long>{
    
}
