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
@Table(name = "parr", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Parr.findAll", query = "SELECT p FROM Parr p"),
    @NamedQuery(name = "Parr.findByParrId", query = "SELECT p FROM Parr p WHERE p.parrId = :parrId"),
    @NamedQuery(name = "Parr.findByParrnomb", query = "SELECT p FROM Parr p WHERE p.parrnomb = :parrnomb"),
    @NamedQuery(name = "Parr.findByParresta", query = "SELECT p FROM Parr p WHERE p.parresta = :parresta"),
    @NamedQuery(name = "Parr.findByParruing", query = "SELECT p FROM Parr p WHERE p.parruing = :parruing"),
    @NamedQuery(name = "Parr.findByParrfing", query = "SELECT p FROM Parr p WHERE p.parrfing = :parrfing"),
    @NamedQuery(name = "Parr.findByParrumod", query = "SELECT p FROM Parr p WHERE p.parrumod = :parrumod"),
    @NamedQuery(name = "Parr.findByParrfmod", query = "SELECT p FROM Parr p WHERE p.parrfmod = :parrfmod")})
public class Parr implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "parr__id")
    private String parrId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "parrnomb")
    private String parrnomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parresta")
    private boolean parresta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "parruing")
    private String parruing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "parrfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parrfing;
    @Size(max = 20)
    @Column(name = "parrumod")
    private String parrumod;
    @Column(name = "parrfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parrfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parrId")
    private Collection<Puob> puobCollection;
    @JoinColumn(name = "cant__id", referencedColumnName = "cant__id")
    @ManyToOne(optional = false)
    private Cant cantId;

    public Parr() {
    }

    public Parr(String parrId) {
        this.parrId = parrId;
    }

    public Parr(String parrId, String parrnomb, boolean parresta, String parruing, Date parrfing) {
        this.parrId = parrId;
        this.parrnomb = parrnomb;
        this.parresta = parresta;
        this.parruing = parruing;
        this.parrfing = parrfing;
    }

    public String getParrId() {
        return parrId;
    }

    public void setParrId(String parrId) {
        this.parrId = parrId;
    }

    public String getParrnomb() {
        return parrnomb;
    }

    public void setParrnomb(String parrnomb) {
        this.parrnomb = parrnomb;
    }

    public boolean getParresta() {
        return parresta;
    }

    public void setParresta(boolean parresta) {
        this.parresta = parresta;
    }

    public String getParruing() {
        return parruing;
    }

    public void setParruing(String parruing) {
        this.parruing = parruing;
    }

    public Date getParrfing() {
        return parrfing;
    }

    public void setParrfing(Date parrfing) {
        this.parrfing = parrfing;
    }

    public String getParrumod() {
        return parrumod;
    }

    public void setParrumod(String parrumod) {
        this.parrumod = parrumod;
    }

    public Date getParrfmod() {
        return parrfmod;
    }

    public void setParrfmod(Date parrfmod) {
        this.parrfmod = parrfmod;
    }

    @XmlTransient
    public Collection<Puob> getPuobCollection() {
        return puobCollection;
    }

    public void setPuobCollection(Collection<Puob> puobCollection) {
        this.puobCollection = puobCollection;
    }

    public Cant getCantId() {
        return cantId;
    }

    public void setCantId(Cant cantId) {
        this.cantId = cantId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (parrId != null ? parrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parr)) {
            return false;
        }
        Parr other = (Parr) object;
        if ((this.parrId == null && other.parrId != null) || (this.parrId != null && !this.parrId.equals(other.parrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Parr[ parrId=" + parrId + " ]";
    }
    
}
