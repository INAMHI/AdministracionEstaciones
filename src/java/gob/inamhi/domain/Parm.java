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
@Table(name = "parm", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parm.findAll", query = "SELECT p FROM Parm p"),
    @NamedQuery(name = "Parm.findByParmId", query = "SELECT p FROM Parm p WHERE p.parmId = :parmId"),
    @NamedQuery(name = "Parm.findByParmnemo", query = "SELECT p FROM Parm p WHERE p.parmnemo = :parmnemo"),
    @NamedQuery(name = "Parm.findByParmdesc", query = "SELECT p FROM Parm p WHERE p.parmdesc = :parmdesc"),
    @NamedQuery(name = "Parm.findByParmuing", query = "SELECT p FROM Parm p WHERE p.parmuing = :parmuing"),
    @NamedQuery(name = "Parm.findByParmfing", query = "SELECT p FROM Parm p WHERE p.parmfing = :parmfing"),
    @NamedQuery(name = "Parm.findByParmumod", query = "SELECT p FROM Parm p WHERE p.parmumod = :parmumod"),
    @NamedQuery(name = "Parm.findByParmfmod", query = "SELECT p FROM Parm p WHERE p.parmfmod = :parmfmod")})
public class Parm implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parmId")
    private Collection<Copa> copaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "parm__id")
    private Integer parmId;
    @Size(max = 1000)
    @Column(name = "parmnemo")
    private String parmnemo;
    @Size(max = 1000)
    @Column(name = "parmdesc")
    private String parmdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "parmuing")
    private String parmuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parmfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parmfing;
    @Size(max = 20)
    @Column(name = "parmumod")
    private String parmumod;
    @Column(name = "parmfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parmfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parmId")
    private Collection<Tipar> tiparCollection;

    public Parm() {
    }

    public Parm(Integer parmId) {
        this.parmId = parmId;
    }

    public Parm(Integer parmId, String parmuing, Date parmfing) {
        this.parmId = parmId;
        this.parmuing = parmuing;
        this.parmfing = parmfing;
    }

    public Integer getParmId() {
        return parmId;
    }

    public void setParmId(Integer parmId) {
        this.parmId = parmId;
    }

    public String getParmnemo() {
        return parmnemo;
    }

    public void setParmnemo(String parmnemo) {
        this.parmnemo = parmnemo;
    }

    public String getParmdesc() {
        return parmdesc;
    }

    public void setParmdesc(String parmdesc) {
        this.parmdesc = parmdesc;
    }

    public String getParmuing() {
        return parmuing;
    }

    public void setParmuing(String parmuing) {
        this.parmuing = parmuing;
    }

    public Date getParmfing() {
        return parmfing;
    }

    public void setParmfing(Date parmfing) {
        this.parmfing = parmfing;
    }

    public String getParmumod() {
        return parmumod;
    }

    public void setParmumod(String parmumod) {
        this.parmumod = parmumod;
    }

    public Date getParmfmod() {
        return parmfmod;
    }

    public void setParmfmod(Date parmfmod) {
        this.parmfmod = parmfmod;
    }

    @XmlTransient
    public Collection<Tipar> getTiparCollection() {
        return tiparCollection;
    }

    public void setTiparCollection(Collection<Tipar> tiparCollection) {
        this.tiparCollection = tiparCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parmId != null ? parmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parm)) {
            return false;
        }
        Parm other = (Parm) object;
        if ((this.parmId == null && other.parmId != null) || (this.parmId != null && !this.parmId.equals(other.parmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Parm[ parmId=" + parmId + " ]";
    }

    @XmlTransient
    public Collection<Copa> getCopaCollection() {
        return copaCollection;
    }

    public void setCopaCollection(Collection<Copa> copaCollection) {
        this.copaCollection = copaCollection;
    }
}
