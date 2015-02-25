/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "inte", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inte.findAll", query = "SELECT i FROM Inte i"),
    @NamedQuery(name = "Inte.findByInteId", query = "SELECT i FROM Inte i WHERE i.inteId = :inteId"),
    @NamedQuery(name = "Inte.findByIntetiemp", query = "SELECT i FROM Inte i WHERE i.intetiemp = :intetiemp"),
    @NamedQuery(name = "Inte.findByInteuing", query = "SELECT i FROM Inte i WHERE i.inteuing = :inteuing"),
    @NamedQuery(name = "Inte.findByIntefing", query = "SELECT i FROM Inte i WHERE i.intefing = :intefing"),
    @NamedQuery(name = "Inte.findByInteumod", query = "SELECT i FROM Inte i WHERE i.inteumod = :inteumod"),
    @NamedQuery(name = "Inte.findByIntefmod", query = "SELECT i FROM Inte i WHERE i.intefmod = :intefmod")})
public class Inte implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inte__id")
    private Integer inteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intetiemp")
    private BigInteger intetiemp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inteuing")
    private String inteuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "intefing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intefing;
    @Size(max = 20)
    @Column(name = "inteumod")
    private String inteumod;
    @Column(name = "intefmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date intefmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inteId")
    private Collection<Inut> inutCollection;

    public Inte() {
    }

    public Inte(Integer inteId) {
        this.inteId = inteId;
    }

    public Inte(Integer inteId, BigInteger intetiemp, String inteuing, Date intefing) {
        this.inteId = inteId;
        this.intetiemp = intetiemp;
        this.inteuing = inteuing;
        this.intefing = intefing;
    }

    public Integer getInteId() {
        return inteId;
    }

    public void setInteId(Integer inteId) {
        this.inteId = inteId;
    }

    public BigInteger getIntetiemp() {
        return intetiemp;
    }

    public void setIntetiemp(BigInteger intetiemp) {
        this.intetiemp = intetiemp;
    }

    public String getInteuing() {
        return inteuing;
    }

    public void setInteuing(String inteuing) {
        this.inteuing = inteuing;
    }

    public Date getIntefing() {
        return intefing;
    }

    public void setIntefing(Date intefing) {
        this.intefing = intefing;
    }

    public String getInteumod() {
        return inteumod;
    }

    public void setInteumod(String inteumod) {
        this.inteumod = inteumod;
    }

    public Date getIntefmod() {
        return intefmod;
    }

    public void setIntefmod(Date intefmod) {
        this.intefmod = intefmod;
    }

    @XmlTransient
    public Collection<Inut> getInutCollection() {
        return inutCollection;
    }

    public void setInutCollection(Collection<Inut> inutCollection) {
        this.inutCollection = inutCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inteId != null ? inteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inte)) {
            return false;
        }
        Inte other = (Inte) object;
        if ((this.inteId == null && other.inteId != null) || (this.inteId != null && !this.inteId.equals(other.inteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Inte[ inteId=" + inteId + " ]";
    }
    
}
