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
@Table(name = "regi", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Regi.findAll", query = "SELECT r FROM Regi r"),
    @NamedQuery(name = "Regi.findByRegiId", query = "SELECT r FROM Regi r WHERE r.regiId = :regiId"),
    @NamedQuery(name = "Regi.findByReginomb", query = "SELECT r FROM Regi r WHERE r.reginomb = :reginomb"),
    @NamedQuery(name = "Regi.findByRegiesta", query = "SELECT r FROM Regi r WHERE r.regiesta = :regiesta"),
    @NamedQuery(name = "Regi.findByRegiuing", query = "SELECT r FROM Regi r WHERE r.regiuing = :regiuing"),
    @NamedQuery(name = "Regi.findByRegifing", query = "SELECT r FROM Regi r WHERE r.regifing = :regifing"),
    @NamedQuery(name = "Regi.findByRegiumod", query = "SELECT r FROM Regi r WHERE r.regiumod = :regiumod"),
    @NamedQuery(name = "Regi.findByRegifmod", query = "SELECT r FROM Regi r WHERE r.regifmod = :regifmod")})
public class Regi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "regi__id")
    private String regiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "reginomb")
    private String reginomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regiesta")
    private boolean regiesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "regiuing")
    private String regiuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "regifing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regifing;
    @Size(max = 20)
    @Column(name = "regiumod")
    private String regiumod;
    @Column(name = "regifmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regifmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regiId")
    private Collection<Prov> provCollection;

    public Regi() {
    }

    public Regi(String regiId) {
        this.regiId = regiId;
    }

    public Regi(String regiId, String reginomb, boolean regiesta, String regiuing, Date regifing) {
        this.regiId = regiId;
        this.reginomb = reginomb;
        this.regiesta = regiesta;
        this.regiuing = regiuing;
        this.regifing = regifing;
    }

    public String getRegiId() {
        return regiId;
    }

    public void setRegiId(String regiId) {
        this.regiId = regiId;
    }

    public String getReginomb() {
        return reginomb;
    }

    public void setReginomb(String reginomb) {
        this.reginomb = reginomb;
    }

    public boolean getRegiesta() {
        return regiesta;
    }

    public void setRegiesta(boolean regiesta) {
        this.regiesta = regiesta;
    }

    public String getRegiuing() {
        return regiuing;
    }

    public void setRegiuing(String regiuing) {
        this.regiuing = regiuing;
    }

    public Date getRegifing() {
        return regifing;
    }

    public void setRegifing(Date regifing) {
        this.regifing = regifing;
    }

    public String getRegiumod() {
        return regiumod;
    }

    public void setRegiumod(String regiumod) {
        this.regiumod = regiumod;
    }

    public Date getRegifmod() {
        return regifmod;
    }

    public void setRegifmod(Date regifmod) {
        this.regifmod = regifmod;
    }

    @XmlTransient
    public Collection<Prov> getProvCollection() {
        return provCollection;
    }

    public void setProvCollection(Collection<Prov> provCollection) {
        this.provCollection = provCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regiId != null ? regiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regi)) {
            return false;
        }
        Regi other = (Regi) object;
        if ((this.regiId == null && other.regiId != null) || (this.regiId != null && !this.regiId.equals(other.regiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Regi[ regiId=" + regiId + " ]";
    }
    
}
