package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Contatos;

public interface ContatosRepository extends JpaRepository<Contatos, Long>{
    
}
