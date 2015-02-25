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
@Table(name = "cant", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cant.findAll", query = "SELECT c FROM Cant c"),
    @NamedQuery(name = "Cant.findByCantId", query = "SELECT c FROM Cant c WHERE c.cantId = :cantId"),
    @NamedQuery(name = "Cant.findByCantnomb", query = "SELECT c FROM Cant c WHERE c.cantnomb = :cantnomb"),
    @NamedQuery(name = "Cant.findByProvesta", query = "SELECT c FROM Cant c WHERE c.provesta = :provesta"),
    @NamedQuery(name = "Cant.findByCantuing", query = "SELECT c FROM Cant c WHERE c.cantuing = :cantuing"),
    @NamedQuery(name = "Cant.findByCantfing", query = "SELECT c FROM Cant c WHERE c.cantfing = :cantfing"),
    @NamedQuery(name = "Cant.findByCantumod", query = "SELECT c FROM Cant c WHERE c.cantumod = :cantumod"),
    @NamedQuery(name = "Cant.findByCantfmod", query = "SELECT c FROM Cant c WHERE c.cantfmod = :cantfmod")})
public class Cant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "cant__id")
    private String cantId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "cantnomb")
    private String cantnomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provesta")
    private boolean provesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "cantuing")
    private String cantuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cantfing;
    @Size(max = 50)
    @Column(name = "cantumod")
    private String cantumod;
    @Column(name = "cantfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cantfmod;
    @JoinColumn(name = "prov__id", referencedColumnName = "prov__id")
    @ManyToOne(optional = false)
    private Prov provId;
    @JoinColumn(name = "dist__id", referencedColumnName = "dist__id")
    @ManyToOne
    private Dist distId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cantId")
    private Collection<Parr> parrCollection;

    public Cant() {
    }

    public Cant(String cantId) {
        this.cantId = cantId;
    }

    public Cant(String cantId, String cantnomb, boolean provesta, String cantuing, Date cantfing) {
        this.cantId = cantId;
        this.cantnomb = cantnomb;
        this.provesta = provesta;
        this.cantuing = cantuing;
        this.cantfing = cantfing;
    }

    public String getCantId() {
        return cantId;
    }

    public void setCantId(String cantId) {
        this.cantId = cantId;
    }

    public String getCantnomb() {
        return cantnomb;
    }

    public void setCantnomb(String cantnomb) {
        this.cantnomb = cantnomb;
    }

    public boolean getProvesta() {
        return provesta;
    }

    public void setProvesta(boolean provesta) {
        this.provesta = provesta;
    }

    public String getCantuing() {
        return cantuing;
    }

    public void setCantuing(String cantuing) {
        this.cantuing = cantuing;
    }

    public Date getCantfing() {
        return cantfing;
    }

    public void setCantfing(Date cantfing) {
        this.cantfing = cantfing;
    }

    public String getCantumod() {
        return cantumod;
    }

    public void setCantumod(String cantumod) {
        this.cantumod = cantumod;
    }

    public Date getCantfmod() {
        return cantfmod;
    }

    public void setCantfmod(Date cantfmod) {
        this.cantfmod = cantfmod;
    }

    public Prov getProvId() {
        return provId;
    }

    public void setProvId(Prov provId) {
        this.provId = provId;
    }

    public Dist getDistId() {
        return distId;
    }

    public void setDistId(Dist distId) {
        this.distId = distId;
    }

    @XmlTransient
    public Collection<Parr> getParrCollection() {
        return parrCollection;
    }

    public void setParrCollection(Collection<Parr> parrCollection) {
        this.parrCollection = parrCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cantId != null ? cantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cant)) {
            return false;
        }
        Cant other = (Cant) object;
        if ((this.cantId == null && other.cantId != null) || (this.cantId != null && !this.cantId.equals(other.cantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cant[ cantId=" + cantId + " ]";
    }
    
}
