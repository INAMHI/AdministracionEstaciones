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
@Table(name = "acces", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Acces.findAll", query = "SELECT a FROM Acces a"),
    @NamedQuery(name = "Acces.findByAccesId", query = "SELECT a FROM Acces a WHERE a.accesId = :accesId"),
    @NamedQuery(name = "Acces.findByAccesnomb", query = "SELECT a FROM Acces a WHERE a.accesnomb = :accesnomb"),
    @NamedQuery(name = "Acces.findByAccesdesc", query = "SELECT a FROM Acces a WHERE a.accesdesc = :accesdesc")})
public class Acces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "acces__id")
    private Integer accesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "accesnomb")
    private String accesnomb;
    @Size(max = 500)
    @Column(name = "accesdesc")
    private String accesdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "accesId")
    private Collection<Puob> puobCollection;

    public Acces() {
    }

    public Acces(Integer accesId) {
        this.accesId = accesId;
    }

    public Acces(Integer accesId, String accesnomb) {
        this.accesId = accesId;
        this.accesnomb = accesnomb;
    }

    public Integer getAccesId() {
        return accesId;
    }

    public void setAccesId(Integer accesId) {
        this.accesId = accesId;
    }

    public String getAccesnomb() {
        return accesnomb;
    }

    public void setAccesnomb(String accesnomb) {
        this.accesnomb = accesnomb;
    }

    public String getAccesdesc() {
        return accesdesc;
    }

    public void setAccesdesc(String accesdesc) {
        this.accesdesc = accesdesc;
    }

    @XmlTransient
    public Collection<Puob> getPuobCollection() {
        return puobCollection;
    }

    public void setPuobCollection(Collection<Puob> puobCollection) {
        this.puobCollection = puobCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accesId != null ? accesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acces)) {
            return false;
        }
        Acces other = (Acces) object;
        if ((this.accesId == null && other.accesId != null) || (this.accesId != null && !this.accesId.equals(other.accesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Acces[ accesId=" + accesId + " ]";
    }
    
}
