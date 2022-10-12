package br.com.hybridinnovation.digitalcare.model;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TB_SINTOMAS")
public class Sintoma {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_sintoma", precision = 0, scale = 9)
    private long id;

    @NotBlank
    @Column(name = "ds_sintoma", length = 80)
    private String sintoma;
    
    @JsonIgnore
    @OneToMany(mappedBy = "sintoma", cascade = CascadeType.REMOVE)
    private List<SintomaAtendimento> sintomasAtendimento = new ArrayList<SintomaAtendimento>();

    
    public Sintoma() {
    }

    public Sintoma(@NotBlank String sintoma) {
        this.sintoma = sintoma;
    }

    public Sintoma(@NotBlank String sintoma, List<SintomaAtendimento> sintomasAtendimento) {
        this.sintoma = sintoma;
        this.sintomasAtendimento = sintomasAtendimento;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSintoma() {
        return sintoma;
    }

    public void setSintoma(String sintoma) {
        this.sintoma = sintoma;
    }

    public List<SintomaAtendimento> getSintomasAtendimento() {
        return sintomasAtendimento;
    }

    public void setSintomasAtendimento(List<SintomaAtendimento> sintomasAtendimento) {
        this.sintomasAtendimento = sintomasAtendimento;
    }

    public void addSintomaAtendimento(SintomaAtendimento sintomaAtendimento) {
        sintomasAtendimento.add(sintomaAtendimento);
        sintomaAtendimento.setSintoma(this);
    }

    @Override
    public String toString() {
        return "Sintoma [id=" + id + ", sintoma=" + sintoma + "]";
    }

    
}
