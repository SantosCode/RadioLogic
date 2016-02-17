/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author luis
 */
@Entity
@Table(catalog = "radiologia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Convenio.findAll", query = "SELECT c FROM Convenio c"),
    @NamedQuery(name = "Convenio.findByIdconvenio", query = "SELECT c FROM Convenio c WHERE c.idconvenio = :idconvenio"),
    @NamedQuery(name = "Convenio.findByNome", query = "SELECT c FROM Convenio c WHERE c.nome = :nome")})
public class Convenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idconvenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
   
    public Convenio() {
    }

    public Convenio(Long idconvenio) {
        this.idconvenio = idconvenio;
    }

    public Convenio(Long idconvenio, String nome) {
        this.idconvenio = idconvenio;
        this.nome = nome;
    }

    public Long getIdconvenio() {
        return idconvenio;
    }

    public void setIdconvenio(Long idconvenio) {
        this.idconvenio = idconvenio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconvenio != null ? idconvenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Convenio)) {
            return false;
        }
        Convenio other = (Convenio) object;
        if ((this.idconvenio == null && other.idconvenio != null) || (this.idconvenio != null && !this.idconvenio.equals(other.idconvenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.nfsconsultoria.radiologic.domain.Convenio[ idconvenio=" + idconvenio + " ]";
    }
    
}
