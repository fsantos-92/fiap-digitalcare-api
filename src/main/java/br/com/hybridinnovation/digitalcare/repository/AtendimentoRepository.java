package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Atendimento;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long>{
    
}
