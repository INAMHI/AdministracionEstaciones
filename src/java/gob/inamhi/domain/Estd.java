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
@Table(name = "estd", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estd.findAll", query = "SELECT e FROM Estd e"),
    @NamedQuery(name = "Estd.findByEstdId", query = "SELECT e FROM Estd e WHERE e.estdId = :estdId"),
    @NamedQuery(name = "Estd.findByEstdcomp", query = "SELECT e FROM Estd e WHERE e.estdcomp = :estdcomp"),
    @NamedQuery(name = "Estd.findByEstdsimb", query = "SELECT e FROM Estd e WHERE e.estdsimb = :estdsimb"),
    @NamedQuery(name = "Estd.findByEstddesc", query = "SELECT e FROM Estd e WHERE e.estddesc = :estddesc"),
    @NamedQuery(name = "Estd.findByEstduing", query = "SELECT e FROM Estd e WHERE e.estduing = :estduing"),
    @NamedQuery(name = "Estd.findByEstdfing", query = "SELECT e FROM Estd e WHERE e.estdfing = :estdfing"),
    @NamedQuery(name = "Estd.findByEstdumod", query = "SELECT e FROM Estd e WHERE e.estdumod = :estdumod"),
    @NamedQuery(name = "Estd.findByEstdfmod", query = "SELECT e FROM Estd e WHERE e.estdfmod = :estdfmod")})
public class Estd implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "estd__id")
    private Integer estdId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "estdcomp")
    private String estdcomp;
    @Size(max = 1000)
    @Column(name = "estdsimb")
    private String estdsimb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "estddesc")
    private String estddesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "estduing")
    private String estduing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estdfing")
    @Temporal(TemporalType.DATE)
    private Date estdfing;
    @Size(max = 20)
    @Column(name = "estdumod")
    private String estdumod;
    @Column(name = "estdfmod")
    @Temporal(TemporalType.DATE)
    private Date estdfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estdId")
    private Collection<Copa> copaCollection;

    public Estd() {
    }

    public Estd(Integer estdId) {
        this.estdId = estdId;
    }

    public Estd(Integer estdId, String estdcomp, String estddesc, String estduing, Date estdfing) {
        this.estdId = estdId;
        this.estdcomp = estdcomp;
        this.estddesc = estddesc;
        this.estduing = estduing;
        this.estdfing = estdfing;
    }

    public Integer getEstdId() {
        return estdId;
    }

    public void setEstdId(Integer estdId) {
        this.estdId = estdId;
    }

    public String getEstdcomp() {
        return estdcomp;
    }

    public void setEstdcomp(String estdcomp) {
        this.estdcomp = estdcomp;
    }

    public String getEstdsimb() {
        return estdsimb;
    }

    public void setEstdsimb(String estdsimb) {
        this.estdsimb = estdsimb;
    }

    public String getEstddesc() {
        return estddesc;
    }

    public void setEstddesc(String estddesc) {
        this.estddesc = estddesc;
    }

    public String getEstduing() {
        return estduing;
    }

    public void setEstduing(String estduing) {
        this.estduing = estduing;
    }

    public Date getEstdfing() {
        return estdfing;
    }

    public void setEstdfing(Date estdfing) {
        this.estdfing = estdfing;
    }

    public String getEstdumod() {
        return estdumod;
    }

    public void setEstdumod(String estdumod) {
        this.estdumod = estdumod;
    }

    public Date getEstdfmod() {
        return estdfmod;
    }

    public void setEstdfmod(Date estdfmod) {
        this.estdfmod = estdfmod;
    }

    @XmlTransient
    public Collection<Copa> getCopaCollection() {
        return copaCollection;
    }

    public void setCopaCollection(Collection<Copa> copaCollection) {
        this.copaCollection = copaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estdId != null ? estdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estd)) {
            return false;
        }
        Estd other = (Estd) object;
        if ((this.estdId == null && other.estdId != null) || (this.estdId != null && !this.estdId.equals(other.estdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Estd[ estdId=" + estdId + " ]";
    }
    
}
