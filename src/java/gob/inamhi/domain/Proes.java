/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "proes", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proes.findAll", query = "SELECT p FROM Proes p"),
    @NamedQuery(name = "Proes.findByProesId", query = "SELECT p FROM Proes p WHERE p.proesId = :proesId"),
    @NamedQuery(name = "Proes.findByProesnomb", query = "SELECT p FROM Proes p WHERE p.proesnomb = :proesnomb"),
    @NamedQuery(name = "Proes.findByProesrep", query = "SELECT p FROM Proes p WHERE p.proesrep = :proesrep"),
    @NamedQuery(name = "Proes.findByProesdir", query = "SELECT p FROM Proes p WHERE p.proesdir = :proesdir"),
    @NamedQuery(name = "Proes.findByProestlf", query = "SELECT p FROM Proes p WHERE p.proestlf = :proestlf"),
    @NamedQuery(name = "Proes.findByProesemai", query = "SELECT p FROM Proes p WHERE p.proesemai = :proesemai"),
    @NamedQuery(name = "Proes.findByProesitec", query = "SELECT p FROM Proes p WHERE p.proesitec = :proesitec"),
    @NamedQuery(name = "Proes.findByProesunig", query = "SELECT p FROM Proes p WHERE p.proesunig = :proesunig"),
    @NamedQuery(name = "Proes.findByProesfing", query = "SELECT p FROM Proes p WHERE p.proesfing = :proesfing"),
    @NamedQuery(name = "Proes.findByProesumod", query = "SELECT p FROM Proes p WHERE p.proesumod = :proesumod"),
    @NamedQuery(name = "Proes.findByProesfmod", query = "SELECT p FROM Proes p WHERE p.proesfmod = :proesfmod")})
public class Proes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "proes__id")
    private Integer proesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "proesnomb")
    private String proesnomb;
    @Size(max = 100)
    @Column(name = "proesrep")
    private String proesrep;
    @Size(max = 100)
    @Column(name = "proesdir")
    private String proesdir;
    @Size(max = 100)
    @Column(name = "proestlf")
    private String proestlf;
    @Size(max = 100)
    @Column(name = "proesemai")
    private String proesemai;
    @Size(max = 100)
    @Column(name = "proesitec")
    private String proesitec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "proesunig")
    private String proesunig;
    @Basic(optional = false)
    @NotNull
    @Column(name = "proesfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proesfing;
    @Size(max = 20)
    @Column(name = "proesumod")
    private String proesumod;
    @Column(name = "proesfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date proesfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proesId")
    private Collection<Esta> estaCollection;

    public Proes() {
    }

    public Proes(Integer proesId) {
        this.proesId = proesId;
    }

    public Proes(Integer proesId, String proesnomb, String proesunig, Date proesfing) {
        this.proesId = proesId;
        this.proesnomb = proesnomb;
        this.proesunig = proesunig;
        this.proesfing = proesfing;
    }

    public Integer getProesId() {
        return proesId;
    }

    public void setProesId(Integer proesId) {
        this.proesId = proesId;
    }

    public String getProesnomb() {
        return proesnomb;
    }

    public void setProesnomb(String proesnomb) {
        this.proesnomb = proesnomb;
    }

    public String getProesrep() {
        return proesrep;
    }

    public void setProesrep(String proesrep) {
        this.proesrep = proesrep;
    }

    public String getProesdir() {
        return proesdir;
    }

    public void setProesdir(String proesdir) {
        this.proesdir = proesdir;
    }

    public String getProestlf() {
        return proestlf;
    }

    public void setProestlf(String proestlf) {
        this.proestlf = proestlf;
    }

    public String getProesemai() {
        return proesemai;
    }

    public void setProesemai(String proesemai) {
        this.proesemai = proesemai;
    }

    public String getProesitec() {
        return proesitec;
    }

    public void setProesitec(String proesitec) {
        this.proesitec = proesitec;
    }

    public String getProesunig() {
        return proesunig;
    }

    public void setProesunig(String proesunig) {
        this.proesunig = proesunig;
    }

    public Date getProesfing() {
        return proesfing;
    }

    public void setProesfing(Date proesfing) {
        this.proesfing = proesfing;
    }

    public String getProesumod() {
        return proesumod;
    }

    public void setProesumod(String proesumod) {
        this.proesumod = proesumod;
    }

    public Date getProesfmod() {
        return proesfmod;
    }

    public void setProesfmod(Date proesfmod) {
        this.proesfmod = proesfmod;
    }

    @XmlTransient
    public Collection<Esta> getEstaCollection() {
        return estaCollection;
    }

    public void setEstaCollection(Collection<Esta> estaCollection) {
        this.estaCollection = estaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (proesId != null ? proesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proes)) {
            return false;
        }
        Proes other = (Proes) object;
        if ((this.proesId == null && other.proesId != null) || (this.proesId != null && !this.proesId.equals(other.proesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Proes[ proesId=" + proesId + " ]";
    }
    
}
