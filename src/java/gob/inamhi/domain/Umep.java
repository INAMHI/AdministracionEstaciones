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
@Table(name = "umep", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Umep.findAll", query = "SELECT u FROM Umep u"),
    @NamedQuery(name = "Umep.findByUmepId", query = "SELECT u FROM Umep u WHERE u.umepId = :umepId"),
    @NamedQuery(name = "Umep.findByUmepsimb", query = "SELECT u FROM Umep u WHERE u.umepsimb = :umepsimb"),
    @NamedQuery(name = "Umep.findByUmepnomb", query = "SELECT u FROM Umep u WHERE u.umepnomb = :umepnomb"),
    @NamedQuery(name = "Umep.findByUmepuing", query = "SELECT u FROM Umep u WHERE u.umepuing = :umepuing"),
    @NamedQuery(name = "Umep.findByUmepumod", query = "SELECT u FROM Umep u WHERE u.umepumod = :umepumod"),
    @NamedQuery(name = "Umep.findByUmepcodi", query = "SELECT u FROM Umep u WHERE u.umepcodi = :umepcodi"),
    @NamedQuery(name = "Umep.findByUmepfing", query = "SELECT u FROM Umep u WHERE u.umepfing = :umepfing"),
    @NamedQuery(name = "Umep.findByUmepfmod", query = "SELECT u FROM Umep u WHERE u.umepfmod = :umepfmod")})
public class Umep implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "umep__id")
    private Integer umepId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "umepsimb")
    private String umepsimb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "umepnomb")
    private String umepnomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "umepuing")
    private String umepuing;
    @Size(max = 20)
    @Column(name = "umepumod")
    private String umepumod;
    @Column(name = "umepcodi")
    private Integer umepcodi;
    @Column(name = "umepfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umepfing;
    @Column(name = "umepfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umepfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "umepId")
    private Collection<Copa> copaCollection;

    public Umep() {
    }

    public Umep(Integer umepId) {
        this.umepId = umepId;
    }

    public Umep(Integer umepId, String umepsimb, String umepnomb, String umepuing) {
        this.umepId = umepId;
        this.umepsimb = umepsimb;
        this.umepnomb = umepnomb;
        this.umepuing = umepuing;
    }

    public Integer getUmepId() {
        return umepId;
    }

    public void setUmepId(Integer umepId) {
        this.umepId = umepId;
    }

    public String getUmepsimb() {
        return umepsimb;
    }

    public void setUmepsimb(String umepsimb) {
        this.umepsimb = umepsimb;
    }

    public String getUmepnomb() {
        return umepnomb;
    }

    public void setUmepnomb(String umepnomb) {
        this.umepnomb = umepnomb;
    }

    public String getUmepuing() {
        return umepuing;
    }

    public void setUmepuing(String umepuing) {
        this.umepuing = umepuing;
    }

    public String getUmepumod() {
        return umepumod;
    }

    public void setUmepumod(String umepumod) {
        this.umepumod = umepumod;
    }

    public Integer getUmepcodi() {
        return umepcodi;
    }

    public void setUmepcodi(Integer umepcodi) {
        this.umepcodi = umepcodi;
    }

    public Date getUmepfing() {
        return umepfing;
    }

    public void setUmepfing(Date umepfing) {
        this.umepfing = umepfing;
    }

    public Date getUmepfmod() {
        return umepfmod;
    }

    public void setUmepfmod(Date umepfmod) {
        this.umepfmod = umepfmod;
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
        hash += (umepId != null ? umepId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Umep)) {
            return false;
        }
        Umep other = (Umep) object;
        if ((this.umepId == null && other.umepId != null) || (this.umepId != null && !this.umepId.equals(other.umepId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Umep[ umepId=" + umepId + " ]";
    }
    
}
