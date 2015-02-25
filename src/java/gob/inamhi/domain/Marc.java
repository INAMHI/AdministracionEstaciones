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
@Table(name = "marc", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Marc.findAll", query = "SELECT m FROM Marc m"),
    @NamedQuery(name = "Marc.findByMarcId", query = "SELECT m FROM Marc m WHERE m.marcId = :marcId"),
    @NamedQuery(name = "Marc.findByMarcnomb", query = "SELECT m FROM Marc m WHERE m.marcnomb = :marcnomb"),
    @NamedQuery(name = "Marc.findByMarcdesc", query = "SELECT m FROM Marc m WHERE m.marcdesc = :marcdesc"),
    @NamedQuery(name = "Marc.findByMarcfecr", query = "SELECT m FROM Marc m WHERE m.marcfecr = :marcfecr"),
    @NamedQuery(name = "Marc.findByMarcesta", query = "SELECT m FROM Marc m WHERE m.marcesta = :marcesta"),
    @NamedQuery(name = "Marc.findByMarccaes", query = "SELECT m FROM Marc m WHERE m.marccaes = :marccaes"),
    @NamedQuery(name = "Marc.findByMarcuing", query = "SELECT m FROM Marc m WHERE m.marcuing = :marcuing"),
    @NamedQuery(name = "Marc.findByMarcfing", query = "SELECT m FROM Marc m WHERE m.marcfing = :marcfing"),
    @NamedQuery(name = "Marc.findByMarcumod", query = "SELECT m FROM Marc m WHERE m.marcumod = :marcumod"),
    @NamedQuery(name = "Marc.findByMarcfmod", query = "SELECT m FROM Marc m WHERE m.marcfmod = :marcfmod")})
public class Marc implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marc__id")
    private Integer marcId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "marcnomb")
    private String marcnomb;
    @Size(max = 2147483647)
    @Column(name = "marcdesc")
    private String marcdesc;
    @Column(name = "marcfecr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcfecr;
    @Column(name = "marcesta")
    private Boolean marcesta;
    @Size(max = 2147483647)
    @Column(name = "marccaes")
    private String marccaes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "marcuing")
    private String marcuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "marcfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcfing;
    @Size(max = 20)
    @Column(name = "marcumod")
    private String marcumod;
    @Column(name = "marcfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date marcfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marcId")
    private Collection<Inhm> inhmCollection;

    public Marc() {
    }

    public Marc(Integer marcId) {
        this.marcId = marcId;
    }

    public Marc(Integer marcId, String marcnomb, String marcuing, Date marcfing) {
        this.marcId = marcId;
        this.marcnomb = marcnomb;
        this.marcuing = marcuing;
        this.marcfing = marcfing;
    }

    public Integer getMarcId() {
        return marcId;
    }

    public void setMarcId(Integer marcId) {
        this.marcId = marcId;
    }

    public String getMarcnomb() {
        return marcnomb;
    }

    public void setMarcnomb(String marcnomb) {
        this.marcnomb = marcnomb;
    }

    public String getMarcdesc() {
        return marcdesc;
    }

    public void setMarcdesc(String marcdesc) {
        this.marcdesc = marcdesc;
    }

    public Date getMarcfecr() {
        return marcfecr;
    }

    public void setMarcfecr(Date marcfecr) {
        this.marcfecr = marcfecr;
    }

    public Boolean getMarcesta() {
        return marcesta;
    }

    public void setMarcesta(Boolean marcesta) {
        this.marcesta = marcesta;
    }

    public String getMarccaes() {
        return marccaes;
    }

    public void setMarccaes(String marccaes) {
        this.marccaes = marccaes;
    }

    public String getMarcuing() {
        return marcuing;
    }

    public void setMarcuing(String marcuing) {
        this.marcuing = marcuing;
    }

    public Date getMarcfing() {
        return marcfing;
    }

    public void setMarcfing(Date marcfing) {
        this.marcfing = marcfing;
    }

    public String getMarcumod() {
        return marcumod;
    }

    public void setMarcumod(String marcumod) {
        this.marcumod = marcumod;
    }

    public Date getMarcfmod() {
        return marcfmod;
    }

    public void setMarcfmod(Date marcfmod) {
        this.marcfmod = marcfmod;
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
        hash += (marcId != null ? marcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Marc)) {
            return false;
        }
        Marc other = (Marc) object;
        if ((this.marcId == null && other.marcId != null) || (this.marcId != null && !this.marcId.equals(other.marcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Marc[ marcId=" + marcId + " ]";
    }
    
}
