package br.com.hybridinnovation.digitalcare.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_ATENDIMENTO")
public class Atendimento {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_atendimento", precision = 0, scale = 9)
    private long id;

    @NotNull
    @Column(name = "dt_atendimento")
	private LocalDateTime data;

    @Enumerated(EnumType.STRING)
    @Column(name = "cl_risco", length = 20)
    private ClassificacaoRisco classificacaoRisco;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cd_paciente")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cd_medico")
    private Medico medico;

    @JsonIgnore
    @OneToMany(mappedBy = "atendimento", cascade = CascadeType.REMOVE)
    private List<SintomaAtendimento> sintomasAtendimento = new ArrayList<SintomaAtendimento>();

    public Atendimento(@NotNull LocalDateTime data, ClassificacaoRisco classificacaoRisco,
            Paciente paciente, Medico medico) {
        this.data = data;
        this.classificacaoRisco = classificacaoRisco;
        this.paciente = paciente;
        this.medico = medico;
    }

    public Atendimento() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ClassificacaoRisco getClassificacaoRisco() {
        return classificacaoRisco;
    }

    public void setClassificacaoRisco(ClassificacaoRisco classificacaoRisco) {
        this.classificacaoRisco = classificacaoRisco;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<SintomaAtendimento> getSintomasAtendimento() {
        return sintomasAtendimento;
    }

    public void setSintomasAtendimento(List<SintomaAtendimento> sintomasAtendimento) {
        this.sintomasAtendimento = sintomasAtendimento;
    }
    public void addSintomaAtendimento(SintomaAtendimento sintoma) {
        sintomasAtendimento.add(sintoma);
        sintoma.setAtendimento(this);
    }

    @Override
    public String toString() {
        return "Atendimento [classificacaoRisco=" + classificacaoRisco + ", data=" + data + ", id=" + id + ", medico="
                + medico.getNome() + ", paciente=" + paciente.getNome() + "]";
    }

}
