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
@Table(name = "maces", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maces.findAll", query = "SELECT m FROM Maces m"),
    @NamedQuery(name = "Maces.findByMacesId", query = "SELECT m FROM Maces m WHERE m.macesId = :macesId"),
    @NamedQuery(name = "Maces.findByMacesdesc", query = "SELECT m FROM Maces m WHERE m.macesdesc = :macesdesc")})
public class Maces implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maces__id")
    private Integer macesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "macesdesc")
    private String macesdesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "macesId")
    private Collection<Puob> puobCollection;

    public Maces() {
    }

    public Maces(Integer macesId) {
        this.macesId = macesId;
    }

    public Maces(Integer macesId, String macesdesc) {
        this.macesId = macesId;
        this.macesdesc = macesdesc;
    }

    public Integer getMacesId() {
        return macesId;
    }

    public void setMacesId(Integer macesId) {
        this.macesId = macesId;
    }

    public String getMacesdesc() {
        return macesdesc;
    }

    public void setMacesdesc(String macesdesc) {
        this.macesdesc = macesdesc;
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
        hash += (macesId != null ? macesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Maces)) {
            return false;
        }
        Maces other = (Maces) object;
        if ((this.macesId == null && other.macesId != null) || (this.macesId != null && !this.macesId.equals(other.macesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Maces[ macesId=" + macesId + " ]";
    }
    
}
