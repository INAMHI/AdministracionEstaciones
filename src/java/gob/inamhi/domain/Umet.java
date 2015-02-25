/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "umet", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Umet.findAll", query = "SELECT u FROM Umet u"),
    @NamedQuery(name = "Umet.findByUmetId", query = "SELECT u FROM Umet u WHERE u.umetId = :umetId"),
    @NamedQuery(name = "Umet.findByUmetnomb", query = "SELECT u FROM Umet u WHERE u.umetnomb = :umetnomb"),
    @NamedQuery(name = "Umet.findByUmetuing", query = "SELECT u FROM Umet u WHERE u.umetuing = :umetuing"),
    @NamedQuery(name = "Umet.findByUmetfing", query = "SELECT u FROM Umet u WHERE u.umetfing = :umetfing"),
    @NamedQuery(name = "Umet.findByUmetumod", query = "SELECT u FROM Umet u WHERE u.umetumod = :umetumod"),
    @NamedQuery(name = "Umet.findByUmetfmod", query = "SELECT u FROM Umet u WHERE u.umetfmod = :umetfmod")})
public class Umet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "umet__id")
    private String umetId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "umetnomb")
    private String umetnomb;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "umetuing")
    private String umetuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "umetfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umetfing;
    @Size(max = 20)
    @Column(name = "umetumod")
    private String umetumod;
    @Column(name = "umetfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date umetfmod;
    @OneToMany(mappedBy = "umetId")
    private Collection<Inut> inutCollection;

    public Umet() {
    }

    public Umet(String umetId) {
        this.umetId = umetId;
    }

    public Umet(String umetId, String umetnomb, String umetuing, Date umetfing) {
        this.umetId = umetId;
        this.umetnomb = umetnomb;
        this.umetuing = umetuing;
        this.umetfing = umetfing;
    }

    public String getUmetId() {
        return umetId;
    }

    public void setUmetId(String umetId) {
        this.umetId = umetId;
    }

    public String getUmetnomb() {
        return umetnomb;
    }

    public void setUmetnomb(String umetnomb) {
        this.umetnomb = umetnomb;
    }

    public String getUmetuing() {
        return umetuing;
    }

    public void setUmetuing(String umetuing) {
        this.umetuing = umetuing;
    }

    public Date getUmetfing() {
        return umetfing;
    }

    public void setUmetfing(Date umetfing) {
        this.umetfing = umetfing;
    }

    public String getUmetumod() {
        return umetumod;
    }

    public void setUmetumod(String umetumod) {
        this.umetumod = umetumod;
    }

    public Date getUmetfmod() {
        return umetfmod;
    }

    public void setUmetfmod(Date umetfmod) {
        this.umetfmod = umetfmod;
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
        hash += (umetId != null ? umetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Umet)) {
            return false;
        }
        Umet other = (Umet) object;
        if ((this.umetId == null && other.umetId != null) || (this.umetId != null && !this.umetId.equals(other.umetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Umet[ umetId=" + umetId + " ]";
    }
    
}
