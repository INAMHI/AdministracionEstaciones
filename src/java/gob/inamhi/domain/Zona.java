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
@Table(name = "zona", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zona.findAll", query = "SELECT z FROM Zona z"),
    @NamedQuery(name = "Zona.findByZonaId", query = "SELECT z FROM Zona z WHERE z.zonaId = :zonaId"),
    @NamedQuery(name = "Zona.findByZonanomb", query = "SELECT z FROM Zona z WHERE z.zonanomb = :zonanomb"),
    @NamedQuery(name = "Zona.findByZonaobse", query = "SELECT z FROM Zona z WHERE z.zonaobse = :zonaobse"),
    @NamedQuery(name = "Zona.findByZonauing", query = "SELECT z FROM Zona z WHERE z.zonauing = :zonauing"),
    @NamedQuery(name = "Zona.findByZonafing", query = "SELECT z FROM Zona z WHERE z.zonafing = :zonafing"),
    @NamedQuery(name = "Zona.findByZonaumod", query = "SELECT z FROM Zona z WHERE z.zonaumod = :zonaumod"),
    @NamedQuery(name = "Zona.findByZonafmod", query = "SELECT z FROM Zona z WHERE z.zonafmod = :zonafmod")})
public class Zona implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "zona__id")
    private String zonaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "zonanomb")
    private String zonanomb;
    @Size(max = 100)
    @Column(name = "zonaobse")
    private String zonaobse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "zonauing")
    private String zonauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "zonafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zonafing;
    @Size(max = 20)
    @Column(name = "zonaumod")
    private String zonaumod;
    @Column(name = "zonafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date zonafmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zonaId")
    private Collection<Prov> provCollection;

    public Zona() {
    }

    public Zona(String zonaId) {
        this.zonaId = zonaId;
    }

    public Zona(String zonaId, String zonanomb, String zonauing, Date zonafing) {
        this.zonaId = zonaId;
        this.zonanomb = zonanomb;
        this.zonauing = zonauing;
        this.zonafing = zonafing;
    }

    public String getZonaId() {
        return zonaId;
    }

    public void setZonaId(String zonaId) {
        this.zonaId = zonaId;
    }

    public String getZonanomb() {
        return zonanomb;
    }

    public void setZonanomb(String zonanomb) {
        this.zonanomb = zonanomb;
    }

    public String getZonaobse() {
        return zonaobse;
    }

    public void setZonaobse(String zonaobse) {
        this.zonaobse = zonaobse;
    }

    public String getZonauing() {
        return zonauing;
    }

    public void setZonauing(String zonauing) {
        this.zonauing = zonauing;
    }

    public Date getZonafing() {
        return zonafing;
    }

    public void setZonafing(Date zonafing) {
        this.zonafing = zonafing;
    }

    public String getZonaumod() {
        return zonaumod;
    }

    public void setZonaumod(String zonaumod) {
        this.zonaumod = zonaumod;
    }

    public Date getZonafmod() {
        return zonafmod;
    }

    public void setZonafmod(Date zonafmod) {
        this.zonafmod = zonafmod;
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
        hash += (zonaId != null ? zonaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zona)) {
            return false;
        }
        Zona other = (Zona) object;
        if ((this.zonaId == null && other.zonaId != null) || (this.zonaId != null && !this.zonaId.equals(other.zonaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Zona[ zonaId=" + zonaId + " ]";
    }
    
}
