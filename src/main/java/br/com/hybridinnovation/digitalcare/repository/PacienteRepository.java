package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
