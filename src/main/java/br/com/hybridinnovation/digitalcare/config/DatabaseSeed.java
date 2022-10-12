package br.com.hybridinnovation.digitalcare.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.hybridinnovation.digitalcare.model.Atendimento;
import br.com.hybridinnovation.digitalcare.model.ClassificacaoRisco;
import br.com.hybridinnovation.digitalcare.model.Contatos;
import br.com.hybridinnovation.digitalcare.model.Endereco;
import br.com.hybridinnovation.digitalcare.model.Medico;
import br.com.hybridinnovation.digitalcare.model.Paciente;
import br.com.hybridinnovation.digitalcare.model.Role;
import br.com.hybridinnovation.digitalcare.model.Sintoma;
import br.com.hybridinnovation.digitalcare.model.SintomaAtendimento;
import br.com.hybridinnovation.digitalcare.model.User;
import br.com.hybridinnovation.digitalcare.repository.AtendimentoRepository;
import br.com.hybridinnovation.digitalcare.repository.ContatosRepository;
import br.com.hybridinnovation.digitalcare.repository.EnderecoRepository;
import br.com.hybridinnovation.digitalcare.repository.MedicoRepository;
import br.com.hybridinnovation.digitalcare.repository.PacienteRepository;
import br.com.hybridinnovation.digitalcare.repository.SintomaAtendimentoRepository;
import br.com.hybridinnovation.digitalcare.repository.SintomaRepository;
import br.com.hybridinnovation.digitalcare.repository.UserRepository;


@Configuration
public class DatabaseSeed implements CommandLineRunner {

    @Autowired
    AtendimentoRepository atendimentoRepository;
    @Autowired
    ContatosRepository contatosRepository;
    @Autowired
    EnderecoRepository enderecoRepository;
    @Autowired
    MedicoRepository medicoRepository;
    @Autowired
    PacienteRepository pacienteRepository;
    @Autowired
    SintomaRepository sintomaRepository;
    @Autowired
    SintomaAtendimentoRepository sintomaAtendimentoRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Paciente paciente1 = new Paciente("Cláudio Manoel Danilo Barbosa", "00444766804", LocalDate.of(1965, Month.JULY, 22));
        Paciente paciente2 = new Paciente("Breno Manoel Cavalcanti", "30665822138", LocalDate.of(1988, Month.SEPTEMBER, 03));
        Paciente paciente3 = new Paciente("Thomas Renan Freitas", "06221886074", LocalDate.of(1990, Month.APRIL, 17));
        
        Endereco endereco1 = new Endereco("Beco Castelo Branco", 607, "Casa 01", "29175648", "Bairro das Laranjeiras", "Serra", "ES", paciente1);
        Endereco endereco2 = new Endereco("Servidão Lídia Lucinda da Silva", 810, "88032657", "Monte Verde", "Florianópolis", "SC", paciente2);
        Endereco endereco3 = new Endereco("Rua D", 318, "49004583", "Zona de Expansão (Robalo)", "Aracaju", "SE", paciente3);
        paciente1.addEndereco(endereco1);
        paciente2.addEndereco(endereco2);
        paciente3.addEndereco(endereco3);

        Contatos contato1 = new Contatos("22", "994448809", "claudio74@afujita.com.br", paciente1);
        Contatos contato2 = new Contatos("86", "27550546", "breno14@brws.com.br", paciente2);
        Contatos contato3 = new Contatos("61", "985127741", "thomasrenan@tglaw.com.br", paciente3);
        paciente1.addContato(contato1);
        paciente2.addContato(contato2);
        paciente3.addContato(contato3);
        
        Medico medico1 = new Medico("Eliane Sabrina Cláudia Dias", "12345", LocalDate.of(2015, Month.JANUARY, 20));
        Medico medico2 = new Medico("Clara Ayla Costa", "54321", LocalDate.of(2019, Month.NOVEMBER, 28));
        Medico medico3 = new Medico("Luiz Edson Jesus", "23456", LocalDate.of(2017, Month.MARCH, 24));

        Sintoma sintoma1 = new Sintoma("Febre");
        Sintoma sintoma2 = new Sintoma("Tosse");
        Sintoma sintoma3 = new Sintoma("Dor no corpo");
        Sintoma sintoma4 = new Sintoma("Dor de cabeça");

        Atendimento atendimento1 = new Atendimento(LocalDateTime.of(2022, Month.MAY, 18, 10, 15), ClassificacaoRisco.VERDE, paciente1, medico1);
        Atendimento atendimento2 = new Atendimento(LocalDateTime.of(2022, Month.APRIL, 05, 10, 15), ClassificacaoRisco.AMARELO, paciente2, medico2);
        Atendimento atendimento3 = new Atendimento(LocalDateTime.of(2022, Month.MAY, 07, 10, 15), ClassificacaoRisco.AMARELO, paciente3, medico3);
        Atendimento atendimento4 = new Atendimento(LocalDateTime.of(2022, Month.MAY, 23, 10, 15), ClassificacaoRisco.AZUL, paciente1, medico2);

        paciente1.addAtendimento(atendimento1);
        paciente2.addAtendimento(atendimento2);
        paciente3.addAtendimento(atendimento3);
        paciente1.addAtendimento(atendimento4);

        medico1.addAtendimento(atendimento1);
        medico2.addAtendimento(atendimento2);
        medico3.addAtendimento(atendimento3);
        medico2.addAtendimento(atendimento4);

        SintomaAtendimento sintomaAtendimento1 = new SintomaAtendimento(sintoma2, atendimento1);
        SintomaAtendimento sintomaAtendimento2 = new SintomaAtendimento(sintoma1, atendimento2);
        SintomaAtendimento sintomaAtendimento3 = new SintomaAtendimento(sintoma3, atendimento3);
        SintomaAtendimento sintomaAtendimento4 = new SintomaAtendimento(sintoma4, atendimento1);
        SintomaAtendimento sintomaAtendimento5 = new SintomaAtendimento(sintoma4, atendimento4);

        atendimento1.addSintomaAtendimento(sintomaAtendimento1);
        atendimento1.addSintomaAtendimento(sintomaAtendimento4);
        atendimento2.addSintomaAtendimento(sintomaAtendimento2);
        atendimento3.addSintomaAtendimento(sintomaAtendimento3);
        atendimento4.addSintomaAtendimento(sintomaAtendimento5);

        pacienteRepository.saveAll(List.of(paciente1, paciente2, paciente3));
        enderecoRepository.saveAll(List.of(endereco1, endereco2, endereco3));
        contatosRepository.saveAll(List.of(contato1, contato2, contato3));
        medicoRepository.saveAll(List.of(medico1, medico2, medico3));
        atendimentoRepository.saveAll(List.of(atendimento1, atendimento2, atendimento3, atendimento4));
        sintomaRepository.saveAll(List.of(sintoma1, sintoma2, sintoma3, sintoma4));
        sintomaAtendimentoRepository.saveAll(List.of(sintomaAtendimento1, sintomaAtendimento2, sintomaAtendimento3, sintomaAtendimento4, sintomaAtendimento5));

        userRepository.save(
            new User()
                .name("Felipe")
                .email("felipe@fiap.com.br")
                .password(passwordEncoder.encode("123"))
                .withRole(new Role("ROLE_ADMIN"))
        );

        userRepository.save(
            new User()
                .name("Pedro")
                .email("pedro@fiap.com.br")
                .password(passwordEncoder.encode("123"))
                .withRole(new Role("ROLE_USER"))
        );
    }
    
}
