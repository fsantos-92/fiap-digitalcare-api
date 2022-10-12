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
@Table(name = "TB_CONTATOS")
public class Contatos {
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_contatos", precision = 0, scale = 9)
    private long id;

    @NotNull
    @Column(name = "nr_ddd", length = 2)
    private String ddd;

    @NotNull
    @Column(name = "nr_telefone", length = 9)
    private String telefone;

    @Column(name = "ds_email", length = 50)
    private String email;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cd_paciente")
    private Paciente paciente;

    public Contatos() {
    }


    public Contatos(@NotNull String ddd, @NotNull String telefone, String email, Paciente paciente) {
        this.ddd = ddd;
        this.telefone = telefone;
        this.email = email;
        this.paciente = paciente;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Contatos [ddd=" + ddd + ", email=" + email + ", id=" + id + ", telefone="
                + telefone + "]";
    }

    
}
