package br.com.hybridinnovation.digitalcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_SINTOMAS_ATENDIMENTO")
public class SintomaAtendimento {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_sintoma_atendimento", precision = 0, scale = 9)
    private long id;

    // @JsonIgnore
    @ManyToOne
    @NotNull
    @JoinColumn(name="cd_sintoma")
    private Sintoma sintoma;

    // @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cd_atendimento")
    private Atendimento atendimento;
    

    public SintomaAtendimento() {
    }

    public SintomaAtendimento(@NotNull Sintoma sintoma, Atendimento atendimento) {
        this.sintoma = sintoma;
        this.atendimento = atendimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Sintoma getSintoma() {
        return sintoma;
    }

    public void setSintoma(Sintoma sintoma) {
        this.sintoma = sintoma;
    }

    public Atendimento getAtendimento() {
        return atendimento;
    }

    public void setAtendimento(Atendimento atendimento) {
        this.atendimento = atendimento;
    }

    @Override
    public String toString() {
        return "SintomaAtendimento [atendimento=" + atendimento + ", id=" + id + ", sintoma=" + sintoma + "]";
    }

    
}
