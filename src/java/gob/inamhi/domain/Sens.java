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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "sens", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sens.findAll", query = "SELECT s FROM Sens s"),
    @NamedQuery(name = "Sens.findBySensId", query = "SELECT s FROM Sens s WHERE s.sensId = :sensId")})
public class Sens implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sens__id")
    private Integer sensId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sensId")
    private Collection<Cfges> cfgesCollection;
    @JoinColumn(name = "inhm__id", referencedColumnName = "inhm__id")
    @ManyToOne(optional = false)
    private Inhm inhmId;

    public Sens() {
    }

    public Sens(Integer sensId) {
        this.sensId = sensId;
    }

    public Integer getSensId() {
        return sensId;
    }

    public void setSensId(Integer sensId) {
        this.sensId = sensId;
    }

    @XmlTransient
    public Collection<Cfges> getCfgesCollection() {
        return cfgesCollection;
    }

    public void setCfgesCollection(Collection<Cfges> cfgesCollection) {
        this.cfgesCollection = cfgesCollection;
    }

    public Inhm getInhmId() {
        return inhmId;
    }

    public void setInhmId(Inhm inhmId) {
        this.inhmId = inhmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sensId != null ? sensId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sens)) {
            return false;
        }
        Sens other = (Sens) object;
        if ((this.sensId == null && other.sensId != null) || (this.sensId != null && !this.sensId.equals(other.sensId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Sens[ sensId=" + sensId + " ]";
    }
    
}
