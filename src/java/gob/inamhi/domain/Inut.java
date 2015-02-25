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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "inut", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inut.findAll", query = "SELECT i FROM Inut i"),
    @NamedQuery(name = "Inut.findByInutId", query = "SELECT i FROM Inut i WHERE i.inutId = :inutId"),
    @NamedQuery(name = "Inut.findByInutuing", query = "SELECT i FROM Inut i WHERE i.inutuing = :inutuing"),
    @NamedQuery(name = "Inut.findByInutfing", query = "SELECT i FROM Inut i WHERE i.inutfing = :inutfing"),
    @NamedQuery(name = "Inut.findByInutumod", query = "SELECT i FROM Inut i WHERE i.inutumod = :inutumod"),
    @NamedQuery(name = "Inut.findByInutfmod", query = "SELECT i FROM Inut i WHERE i.inutfmod = :inutfmod")})
public class Inut implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inut__id")
    private Integer inutId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inutuing")
    private String inutuing;
    @Column(name = "inutfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inutfing;
    @Size(max = 20)
    @Column(name = "inutumod")
    private String inutumod;
    @Column(name = "inutfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inutfmod;
    @JoinColumn(name = "umet__id", referencedColumnName = "umet__id")
    @ManyToOne
    private Umet umetId;
    @JoinColumn(name = "inte__id", referencedColumnName = "inte__id")
    @ManyToOne(optional = false)
    private Inte inteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inutId")
    private Collection<Copa> copaCollection;

    public Inut() {
    }

    public Inut(Integer inutId) {
        this.inutId = inutId;
    }

    public Inut(Integer inutId, String inutuing) {
        this.inutId = inutId;
        this.inutuing = inutuing;
    }

    public Integer getInutId() {
        return inutId;
    }

    public void setInutId(Integer inutId) {
        this.inutId = inutId;
    }

    public String getInutuing() {
        return inutuing;
    }

    public void setInutuing(String inutuing) {
        this.inutuing = inutuing;
    }

    public Date getInutfing() {
        return inutfing;
    }

    public void setInutfing(Date inutfing) {
        this.inutfing = inutfing;
    }

    public String getInutumod() {
        return inutumod;
    }

    public void setInutumod(String inutumod) {
        this.inutumod = inutumod;
    }

    public Date getInutfmod() {
        return inutfmod;
    }

    public void setInutfmod(Date inutfmod) {
        this.inutfmod = inutfmod;
    }

    public Umet getUmetId() {
        return umetId;
    }

    public void setUmetId(Umet umetId) {
        this.umetId = umetId;
    }

    public Inte getInteId() {
        return inteId;
    }

    public void setInteId(Inte inteId) {
        this.inteId = inteId;
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
        hash += (inutId != null ? inutId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inut)) {
            return false;
        }
        Inut other = (Inut) object;
        if ((this.inutId == null && other.inutId != null) || (this.inutId != null && !this.inutId.equals(other.inutId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Inut[ inutId=" + inutId + " ]";
    }
    
}
