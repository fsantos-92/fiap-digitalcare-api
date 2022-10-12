package br.com.hybridinnovation.digitalcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.hybridinnovation.digitalcare.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
