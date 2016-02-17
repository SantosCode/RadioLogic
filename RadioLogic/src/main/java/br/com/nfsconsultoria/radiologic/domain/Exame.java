/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.nfsconsultoria.radiologic.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
    @NamedQuery(name = "Exame.findAll", query = "SELECT e FROM Exame e"),
    @NamedQuery(name = "Exame.findByIdexame", query = "SELECT e FROM Exame e WHERE e.idexame = :idexame"),
    @NamedQuery(name = "Exame.findByNome", query = "SELECT e FROM Exame e WHERE e.nome = :nome"),
    @NamedQuery(name = "Exame.findByValor", query = "SELECT e FROM Exame e WHERE e.valor = :valor")})
public class Exame implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long idexame;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(nullable = false, length = 45)
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal valor;
    @JoinColumn(name = "convenio_idconvenio", referencedColumnName = "idconvenio", nullable = false)
    @ManyToOne(optional = false)
    private Convenio convenioIdconvenio;

    public Exame() {
    }

    public Exame(Long idexame) {
        this.idexame = idexame;
    }

    public Exame(Long idexame, String nome, BigDecimal valor) {
        this.idexame = idexame;
        this.nome = nome;
        this.valor = valor;
    }

    public Long getIdexame() {
        return idexame;
    }

    public void setIdexame(Long idexame) {
        this.idexame = idexame;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
    
    public Convenio getConvenioIdconvenio() {
        return convenioIdconvenio;
    }

    public void setConvenioIdconvenio(Convenio convenioIdconvenio) {
        this.convenioIdconvenio = convenioIdconvenio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idexame != null ? idexame.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Exame)) {
            return false;
        }
        Exame other = (Exame) object;
        if ((this.idexame == null && other.idexame != null) || (this.idexame != null && !this.idexame.equals(other.idexame))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.nfsconsultoria.radiologic.domain.Exame[ idexame=" + idexame + " ]";
    }
    
}
