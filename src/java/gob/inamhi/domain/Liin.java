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
@Table(name = "liin", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Liin.findAll", query = "SELECT l FROM Liin l"),
    @NamedQuery(name = "Liin.findByLiinId", query = "SELECT l FROM Liin l WHERE l.liinId = :liinId"),
    @NamedQuery(name = "Liin.findByLiinnomb", query = "SELECT l FROM Liin l WHERE l.liinnomb = :liinnomb"),
    @NamedQuery(name = "Liin.findByLiindesc", query = "SELECT l FROM Liin l WHERE l.liindesc = :liindesc"),
    @NamedQuery(name = "Liin.findByLiinuing", query = "SELECT l FROM Liin l WHERE l.liinuing = :liinuing"),
    @NamedQuery(name = "Liin.findByLiinfing", query = "SELECT l FROM Liin l WHERE l.liinfing = :liinfing"),
    @NamedQuery(name = "Liin.findByLiinumod", query = "SELECT l FROM Liin l WHERE l.liinumod = :liinumod"),
    @NamedQuery(name = "Liin.findByLiinfmod", query = "SELECT l FROM Liin l WHERE l.liinfmod = :liinfmod")})
public class Liin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "liin__id")
    private Integer liinId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "liinnomb")
    private String liinnomb;
    @Size(max = 2147483647)
    @Column(name = "liindesc")
    private String liindesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "liinuing")
    private String liinuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "liinfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date liinfing;
    @Size(max = 20)
    @Column(name = "liinumod")
    private String liinumod;
    @Column(name = "liinfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date liinfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "liinId")
    private Collection<Inhm> inhmCollection;

    public Liin() {
    }

    public Liin(Integer liinId) {
        this.liinId = liinId;
    }

    public Liin(Integer liinId, String liinnomb, String liinuing, Date liinfing) {
        this.liinId = liinId;
        this.liinnomb = liinnomb;
        this.liinuing = liinuing;
        this.liinfing = liinfing;
    }

    public Integer getLiinId() {
        return liinId;
    }

    public void setLiinId(Integer liinId) {
        this.liinId = liinId;
    }

    public String getLiinnomb() {
        return liinnomb;
    }

    public void setLiinnomb(String liinnomb) {
        this.liinnomb = liinnomb;
    }

    public String getLiindesc() {
        return liindesc;
    }

    public void setLiindesc(String liindesc) {
        this.liindesc = liindesc;
    }

    public String getLiinuing() {
        return liinuing;
    }

    public void setLiinuing(String liinuing) {
        this.liinuing = liinuing;
    }

    public Date getLiinfing() {
        return liinfing;
    }

    public void setLiinfing(Date liinfing) {
        this.liinfing = liinfing;
    }

    public String getLiinumod() {
        return liinumod;
    }

    public void setLiinumod(String liinumod) {
        this.liinumod = liinumod;
    }

    public Date getLiinfmod() {
        return liinfmod;
    }

    public void setLiinfmod(Date liinfmod) {
        this.liinfmod = liinfmod;
    }

    @XmlTransient
    public Collection<Inhm> getInhmCollection() {
        return inhmCollection;
    }

    public void setInhmCollection(Collection<Inhm> inhmCollection) {
        this.inhmCollection = inhmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (liinId != null ? liinId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Liin)) {
            return false;
        }
        Liin other = (Liin) object;
        if ((this.liinId == null && other.liinId != null) || (this.liinId != null && !this.liinId.equals(other.liinId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Liin[ liinId=" + liinId + " ]";
    }
    
}
