package br.com.hybridinnovation.digitalcare.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_PACIENTE")
public class Paciente {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_paciente", precision = 0, scale = 9)
    private long id;

    @NotNull
    @Column(name = "nm_paciente", length = 80)
    private String nome;

    @Column(name = "nr_cpf", length = 11/*, unique = true*/)
    private String cpf;

    @NotNull
    @Column(name = "dt_nascimento")
	private LocalDate dataNascimento;

    @Column(name = "dt_cadastro")
	private LocalDate dataCadastro;

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private List<Endereco> enderecos = new ArrayList<Endereco>();

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private List<Contatos> contatos = new ArrayList<Contatos>();

    @JsonIgnore
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.REMOVE)
    private List<Atendimento> atendimentos = new ArrayList<Atendimento>();
    
    public Paciente() {
    }

    public Paciente(@NotNull String nome, String cpf, @NotNull LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
    
    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
        endereco.setPaciente(this);
    }

    public List<Contatos> getContatos() {
        return contatos;
    }

    public void setContatos(List<Contatos> contatos) {
        this.contatos = contatos;
    }

    public void addContato(Contatos contato) {
        contatos.add(contato);
        contato.setPaciente(this);
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void addAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        atendimento.setPaciente(this);
    }
       
    @Override
    public String toString() {
        return "Paciente [cpf=" + cpf + ", dataCadastro=" + dataCadastro + ", dataNascimento=" + dataNascimento
                + ", id=" + id + ", nome=" + nome + "]";
    }
    
}
