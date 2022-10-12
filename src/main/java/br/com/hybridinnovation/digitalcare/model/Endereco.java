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
@Table(name = "TB_ENDERECO")
public class Endereco {
    
    @Id @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "cd_endereco", precision = 0, scale = 9)
    private long id;

    @NotNull
    @Column(name = "nm_logradouro", length = 90)
    private String logradouro;

    @NotNull
    @Column(name = "nr_endereco", scale = 5)
    private int numero;

    @Column(name = "ds_complemento")
    private String complemento;

    @NotNull
    @Column(name = "nr_cep", length = 8)
    private String cep;

    @NotNull
    @Column(name = "nm_bairro", length = 50)
    private String bairro;

    @NotNull
    @Column(name = "nm_municipio", length = 50)
    private String municipio;

    @NotNull
    @Column(name = "sg_estado", length = 2)
    private String siglaEstado;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cd_paciente")
    private Paciente paciente;
    

    public Endereco() {
    }

    
    public Endereco(@NotNull String logradouro, @NotNull int numero, @NotNull String cep, @NotNull String bairro,
            @NotNull String municipio, @NotNull String siglaEstado, Paciente paciente) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
        this.municipio = municipio;
        this.siglaEstado = siglaEstado;
        this.paciente = paciente;
    }


    public Endereco(@NotNull String logradouro, @NotNull int numero, String complemento, @NotNull String cep,
            @NotNull String bairro, @NotNull String municipio, @NotNull String siglaEstado, Paciente paciente) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.bairro = bairro;
        this.municipio = municipio;
        this.siglaEstado = siglaEstado;
        this.paciente = paciente;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado;
    }

    
    public Paciente getPaciente() {
        return paciente;
    }


    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Endereco [bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + ", id=" + id
                + ", logradouro=" + logradouro + ", municipio=" + municipio + ", numero=" + numero + ", siglaEstado="
                + siglaEstado + "]";
    }
    
}
