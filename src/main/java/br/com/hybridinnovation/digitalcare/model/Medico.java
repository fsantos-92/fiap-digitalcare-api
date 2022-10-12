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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_MEDICO")
public class Medico {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_medico", precision = 0, scale = 9)
    private long id;

    @NotBlank
    @Column(name = "nm_medico", length = 80)
    private String nome;

    @NotNull
    @NotBlank
    @Column(name = "nr_crm", length = 11/* , unique = true*/)
    private String crm;

    @NotNull
    @Column(name = "dt_admissao")
	private LocalDate dataAdmissao;

    @Column(name = "dt_saida")
	private LocalDate dataSaida;

    @JsonIgnore
    @OneToMany(mappedBy = "medico", cascade = CascadeType.REMOVE)
    private List<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public Medico() {
    }

    public Medico(@NotBlank String nome, @NotNull @NotBlank String crm, @NotNull LocalDate dataAdmissao) {
        this.nome = nome;
        this.crm = crm;
        this.dataAdmissao = dataAdmissao;
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

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    public void addAtendimento(Atendimento atendimento) {
        atendimentos.add(atendimento);
        atendimento.setMedico(this);
    }

    @Override
    public String toString() {
        return "Medico [crm=" + crm + ", dataAdmissao=" + dataAdmissao
                + ", dataSaida=" + dataSaida + ", id=" + id + ", nome=" + nome + "]";
    }

    
}
