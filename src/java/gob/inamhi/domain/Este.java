/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

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
 * @author dhinojosa
 */
@Entity
@Table(name = "este", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Este.findAll", query = "SELECT e FROM Este e"),
    @NamedQuery(name = "Este.findByEsteId", query = "SELECT e FROM Este e WHERE e.esteId = :esteId"),
    @NamedQuery(name = "Este.findByEstenomb", query = "SELECT e FROM Este e WHERE e.estenomb = :estenomb"),
    @NamedQuery(name = "Este.findByEsteicon", query = "SELECT e FROM Este e WHERE e.esteicon = :esteicon")})
public class Este implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "este__id")
    private Integer esteId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "estenomb")
    private String estenomb;
    @Size(max = 500)
    @Column(name = "esteicon")
    private String esteicon;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "esteId")
    private Collection<Esta> estaCollection;

    public Este() {
    }

    public Este(Integer esteId) {
        this.esteId = esteId;
    }

    public Este(Integer esteId, String estenomb) {
        this.esteId = esteId;
        this.estenomb = estenomb;
    }

    public Integer getEsteId() {
        return esteId;
    }

    public void setEsteId(Integer esteId) {
        this.esteId = esteId;
    }

    public String getEstenomb() {
        return estenomb;
    }

    public void setEstenomb(String estenomb) {
        this.estenomb = estenomb;
    }

    public String getEsteicon() {
        return esteicon;
    }

    public void setEsteicon(String esteicon) {
        this.esteicon = esteicon;
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
        hash += (esteId != null ? esteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Este)) {
            return false;
        }
        Este other = (Este) object;
        if ((this.esteId == null && other.esteId != null) || (this.esteId != null && !this.esteId.equals(other.esteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Este[ esteId=" + esteId + " ]";
    }
    
}
