/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.domain;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author luis
 */
@Entity
@Table(catalog = "radiologia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dentista.findAll", query = "SELECT d FROM Dentista d"),
    @NamedQuery(name = "Dentista.findByIddentista", query = "SELECT d FROM Dentista d WHERE d.iddentista = :iddentista"),
    @NamedQuery(name = "Dentista.findByNome", query = "SELECT d FROM Dentista d WHERE d.nome = :nome"),
    @NamedQuery(name = "Dentista.findByClinica", query = "SELECT d FROM Dentista d WHERE d.clinica = :clinica"),
    @NamedQuery(name = "Dentista.findByEndereco", query = "SELECT d FROM Dentista d WHERE d.endereco = :endereco"),
    @NamedQuery(name = "Dentista.findByTelefone", query = "SELECT d FROM Dentista d WHERE d.telefone = :telefone"),
    @NamedQuery(name = "Dentista.findByEmail", query = "SELECT d FROM Dentista d WHERE d.email = :email")})
public class Dentista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long iddentista;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
    @Size(max = 45)
    @Column(length = 45)
    private String clinica;
    @Size(max = 80)
    @Column(length = 80)
    private String endereco;
    @Size(max = 30)
    @Column(length = 30)
    private String telefone;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 45)
    @Column(length = 45)
    private String email;
    
    public Dentista() {
    }

    public Dentista(Long iddentista) {
        this.iddentista = iddentista;
    }

    public Dentista(Long iddentista, String nome) {
        this.iddentista = iddentista;
        this.nome = nome;
    }

    public Long getIddentista() {
        return iddentista;
    }

    public void setIddentista(Long iddentista) {
        this.iddentista = iddentista;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddentista != null ? iddentista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dentista)) {
            return false;
        }
        Dentista other = (Dentista) object;
        if ((this.iddentista == null && other.iddentista != null) || (this.iddentista != null && !this.iddentista.equals(other.iddentista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.nfsconsultoria.radiologic.domain.Dentista[ iddentista=" + iddentista + " ]";
    }
    
}
