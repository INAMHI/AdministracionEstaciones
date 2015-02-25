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
@Table(name = "prov", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prov.findAll", query = "SELECT p FROM Prov p"),
    @NamedQuery(name = "Prov.findByProvId", query = "SELECT p FROM Prov p WHERE p.provId = :provId"),
    @NamedQuery(name = "Prov.findByProvnomb", query = "SELECT p FROM Prov p WHERE p.provnomb = :provnomb"),
    @NamedQuery(name = "Prov.findByProvesta", query = "SELECT p FROM Prov p WHERE p.provesta = :provesta"),
    @NamedQuery(name = "Prov.findByProvuing", query = "SELECT p FROM Prov p WHERE p.provuing = :provuing"),
    @NamedQuery(name = "Prov.findByProvfing", query = "SELECT p FROM Prov p WHERE p.provfing = :provfing"),
    @NamedQuery(name = "Prov.findByProvumod", query = "SELECT p FROM Prov p WHERE p.provumod = :provumod"),
    @NamedQuery(name = "Prov.findByProvfmod", query = "SELECT p FROM Prov p WHERE p.provfmod = :provfmod")})
public class Prov implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "prov__id")
    private String provId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "provnomb")
    private String provnomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provesta")
    private boolean provesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "provuing")
    private String provuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "provfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date provfing;
    @Size(max = 20)
    @Column(name = "provumod")
    private String provumod;
    @Column(name = "provfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date provfmod;
    @JoinColumn(name = "zona__id", referencedColumnName = "zona__id")
    @ManyToOne(optional = false)
    private Zona zonaId;
    @JoinColumn(name = "regi__id", referencedColumnName = "regi__id")
    @ManyToOne(optional = false)
    private Regi regiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "provId")
    private Collection<Cant> cantCollection;

    public Prov() {
    }

    public Prov(String provId) {
        this.provId = provId;
    }

    public Prov(String provId, String provnomb, boolean provesta, String provuing, Date provfing) {
        this.provId = provId;
        this.provnomb = provnomb;
        this.provesta = provesta;
        this.provuing = provuing;
        this.provfing = provfing;
    }

    public String getProvId() {
        return provId;
    }

    public void setProvId(String provId) {
        this.provId = provId;
    }

    public String getProvnomb() {
        return provnomb;
    }

    public void setProvnomb(String provnomb) {
        this.provnomb = provnomb;
    }

    public boolean getProvesta() {
        return provesta;
    }

    public void setProvesta(boolean provesta) {
        this.provesta = provesta;
    }

    public String getProvuing() {
        return provuing;
    }

    public void setProvuing(String provuing) {
        this.provuing = provuing;
    }

    public Date getProvfing() {
        return provfing;
    }

    public void setProvfing(Date provfing) {
        this.provfing = provfing;
    }

    public String getProvumod() {
        return provumod;
    }

    public void setProvumod(String provumod) {
        this.provumod = provumod;
    }

    public Date getProvfmod() {
        return provfmod;
    }

    public void setProvfmod(Date provfmod) {
        this.provfmod = provfmod;
    }

    public Zona getZonaId() {
        return zonaId;
    }

    public void setZonaId(Zona zonaId) {
        this.zonaId = zonaId;
    }

    public Regi getRegiId() {
        return regiId;
    }

    public void setRegiId(Regi regiId) {
        this.regiId = regiId;
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
        hash += (provId != null ? provId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prov)) {
            return false;
        }
        Prov other = (Prov) object;
        if ((this.provId == null && other.provId != null) || (this.provId != null && !this.provId.equals(other.provId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Prov[ provId=" + provId + " ]";
    }
    
}
