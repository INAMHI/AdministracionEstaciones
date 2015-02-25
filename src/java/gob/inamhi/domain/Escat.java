/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "escat", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Escat.findAll", query = "SELECT e FROM Escat e"),
    @NamedQuery(name = "Escat.findByEscatId", query = "SELECT e FROM Escat e WHERE e.escatId = :escatId"),
    @NamedQuery(name = "Escat.findByEscatfins", query = "SELECT e FROM Escat e WHERE e.escatfins = :escatfins"),
    @NamedQuery(name = "Escat.findByEscatflev", query = "SELECT e FROM Escat e WHERE e.escatflev = :escatflev"),
    @NamedQuery(name = "Escat.findByEscatadre", query = "SELECT e FROM Escat e WHERE e.escatadre = :escatadre"),
    @NamedQuery(name = "Escat.findByEscatuing", query = "SELECT e FROM Escat e WHERE e.escatuing = :escatuing"),
    @NamedQuery(name = "Escat.findByEscatfing", query = "SELECT e FROM Escat e WHERE e.escatfing = :escatfing"),
    @NamedQuery(name = "Escat.findByEscatumod", query = "SELECT e FROM Escat e WHERE e.escatumod = :escatumod"),
    @NamedQuery(name = "Escat.findByEscatfmod", query = "SELECT e FROM Escat e WHERE e.escatfmod = :escatfmod")})
public class Escat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "escat__id")
    private Integer escatId;
    @Column(name = "escatfins")
    @Temporal(TemporalType.DATE)
    private Date escatfins;
    @Column(name = "escatflev")
    @Temporal(TemporalType.DATE)
    private Date escatflev;
    @Column(name = "escatadre")
    private Integer escatadre;
    @Size(max = 50)
    @Column(name = "escatuing")
    private String escatuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escatfing", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date escatfing;
    @Size(max = 50)
    @Column(name = "escatumod")
    private String escatumod;
    @Column(name = "escatfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date escatfmod;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne(optional = false)
    private Esta estaId;
    @JoinColumn(name = "cati__id", referencedColumnName = "cati__id")
    @ManyToOne(optional = false)
    private Cati catiId;

    public Escat() {
    }

    public Escat(Integer escatId) {
        this.escatId = escatId;
    }

    public Escat(Integer escatId, Date escatfing) {
        this.escatId = escatId;
        this.escatfing = escatfing;
    }

    public Integer getEscatId() {
        return escatId;
    }

    public void setEscatId(Integer escatId) {
        this.escatId = escatId;
    }

    public Date getEscatfins() {
        return escatfins;
    }

    public void setEscatfins(Date escatfins) {
        this.escatfins = escatfins;
    }

    public Date getEscatflev() {
        return escatflev;
    }

    public void setEscatflev(Date escatflev) {
        this.escatflev = escatflev;
    }

    public Integer getEscatadre() {
        return escatadre;
    }

    public void setEscatadre(Integer escatadre) {
        this.escatadre = escatadre;
    }

    public String getEscatuing() {
        return escatuing;
    }

    public void setEscatuing(String escatuing) {
        this.escatuing = escatuing;
    }

    public Date getEscatfing() {
        return escatfing;
    }

    public void setEscatfing(Date escatfing) {
        this.escatfing = escatfing;
    }

    public String getEscatumod() {
        return escatumod;
    }

    public void setEscatumod(String escatumod) {
        this.escatumod = escatumod;
    }

    public Date getEscatfmod() {
        return escatfmod;
    }

    public void setEscatfmod(Date escatfmod) {
        this.escatfmod = escatfmod;
    }

    public Esta getEstaId() {
        return estaId;
    }

    public void setEstaId(Esta estaId) {
        this.estaId = estaId;
    }

    public Cati getCatiId() {
        return catiId;
    }

    public void setCatiId(Cati catiId) {
        this.catiId = catiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (escatId != null ? escatId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Escat)) {
            return false;
        }
        Escat other = (Escat) object;
        if ((this.escatId == null && other.escatId != null) || (this.escatId != null && !this.escatId.equals(other.escatId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Escat[ escatId=" + escatId + " ]";
    }
}
