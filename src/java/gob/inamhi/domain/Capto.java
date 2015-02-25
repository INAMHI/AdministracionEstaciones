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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "capto", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capto.findAll", query = "SELECT c FROM Capto c"),
    @NamedQuery(name = "Capto.findByCaptoId", query = "SELECT c FROM Capto c WHERE c.captoId = :captoId"),
    @NamedQuery(name = "Capto.findByCaptonomb", query = "SELECT c FROM Capto c WHERE c.captonomb = :captonomb"),
    @NamedQuery(name = "Capto.findByCaptodesc", query = "SELECT c FROM Capto c WHERE c.captodesc = :captodesc")})
public class Capto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "capto__id")
    private Integer captoId;
    @Size(max = 50)
    @Column(name = "captonomb")
    private String captonomb;
    @Size(max = 2147483647)
    @Column(name = "captodesc")
    private String captodesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "captoId")
    private Collection<Cati> catiCollection;

    public Capto() {
    }

    public Capto(Integer captoId) {
        this.captoId = captoId;
    }

    public Integer getCaptoId() {
        return captoId;
    }

    public void setCaptoId(Integer captoId) {
        this.captoId = captoId;
    }

    public String getCaptonomb() {
        return captonomb;
    }

    public void setCaptonomb(String captonomb) {
        this.captonomb = captonomb;
    }

    public String getCaptodesc() {
        return captodesc;
    }

    public void setCaptodesc(String captodesc) {
        this.captodesc = captodesc;
    }

    @XmlTransient
    public Collection<Cati> getCatiCollection() {
        return catiCollection;
    }

    public void setCatiCollection(Collection<Cati> catiCollection) {
        this.catiCollection = catiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (captoId != null ? captoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capto)) {
            return false;
        }
        Capto other = (Capto) object;
        if ((this.captoId == null && other.captoId != null) || (this.captoId != null && !this.captoId.equals(other.captoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Capto[ captoId=" + captoId + " ]";
    }
    
}
