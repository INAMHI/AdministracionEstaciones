/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "dist", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dist.findAll", query = "SELECT d FROM Dist d"),
    @NamedQuery(name = "Dist.findByDistId", query = "SELECT d FROM Dist d WHERE d.distId = :distId"),
    @NamedQuery(name = "Dist.findByDistcant", query = "SELECT d FROM Dist d WHERE d.distcant = :distcant"),
    @NamedQuery(name = "Dist.findByDistobse", query = "SELECT d FROM Dist d WHERE d.distobse = :distobse"),
    @NamedQuery(name = "Dist.findByDistuing", query = "SELECT d FROM Dist d WHERE d.distuing = :distuing"),
    @NamedQuery(name = "Dist.findByDistfing", query = "SELECT d FROM Dist d WHERE d.distfing = :distfing"),
    @NamedQuery(name = "Dist.findByDistumod", query = "SELECT d FROM Dist d WHERE d.distumod = :distumod"),
    @NamedQuery(name = "Dist.findByDistfmod", query = "SELECT d FROM Dist d WHERE d.distfmod = :distfmod")})
public class Dist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "dist__id")
    private String distId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 600)
    @Column(name = "distcant")
    private String distcant;
    @Size(max = 100)
    @Column(name = "distobse")
    private String distobse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "distuing")
    private String distuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "distfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date distfing;
    @Size(max = 20)
    @Column(name = "distumod")
    private String distumod;
    @Column(name = "distfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date distfmod;
    @OneToMany(mappedBy = "distId")
    private Collection<Cant> cantCollection;

    public Dist() {
    }

    public Dist(String distId) {
        this.distId = distId;
    }

    public Dist(String distId, String distcant, String distuing, Date distfing) {
        this.distId = distId;
        this.distcant = distcant;
        this.distuing = distuing;
        this.distfing = distfing;
    }

    public String getDistId() {
        return distId;
    }

    public void setDistId(String distId) {
        this.distId = distId;
    }

    public String getDistcant() {
        return distcant;
    }

    public void setDistcant(String distcant) {
        this.distcant = distcant;
    }

    public String getDistobse() {
        return distobse;
    }

    public void setDistobse(String distobse) {
        this.distobse = distobse;
    }

    public String getDistuing() {
        return distuing;
    }

    public void setDistuing(String distuing) {
        this.distuing = distuing;
    }

    public Date getDistfing() {
        return distfing;
    }

    public void setDistfing(Date distfing) {
        this.distfing = distfing;
    }

    public String getDistumod() {
        return distumod;
    }

    public void setDistumod(String distumod) {
        this.distumod = distumod;
    }

    public Date getDistfmod() {
        return distfmod;
    }

    public void setDistfmod(Date distfmod) {
        this.distfmod = distfmod;
    }

    @XmlTransient
    public Collection<Cant> getCantCollection() {
        return cantCollection;
    }

    public void setCantCollection(Collection<Cant> cantCollection) {
        this.cantCollection = cantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (distId != null ? distId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dist)) {
            return false;
        }
        Dist other = (Dist) object;
        if ((this.distId == null && other.distId != null) || (this.distId != null && !this.distId.equals(other.distId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Dist[ distId=" + distId + " ]";
    }
    
}
