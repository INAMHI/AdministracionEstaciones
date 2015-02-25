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
@Table(name = "cuen", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cuen.findAll", query = "SELECT c FROM Cuen c"),
    @NamedQuery(name = "Cuen.findByCuencodi", query = "SELECT c FROM Cuen c WHERE c.cuencodi = :cuencodi"),
    @NamedQuery(name = "Cuen.findByCuennomb", query = "SELECT c FROM Cuen c WHERE c.cuennomb = :cuennomb"),
    @NamedQuery(name = "Cuen.findByCuenesta", query = "SELECT c FROM Cuen c WHERE c.cuenesta = :cuenesta"),
    @NamedQuery(name = "Cuen.findByCuenId", query = "SELECT c FROM Cuen c WHERE c.cuenId = :cuenId"),
    @NamedQuery(name = "Cuen.findByCuennive", query = "SELECT c FROM Cuen c WHERE c.cuennive = :cuennive"),
    @NamedQuery(name = "Cuen.findByCuenuing", query = "SELECT c FROM Cuen c WHERE c.cuenuing = :cuenuing"),
    @NamedQuery(name = "Cuen.findByCuenfing", query = "SELECT c FROM Cuen c WHERE c.cuenfing = :cuenfing"),
    @NamedQuery(name = "Cuen.findByCuenumod", query = "SELECT c FROM Cuen c WHERE c.cuenumod = :cuenumod"),
    @NamedQuery(name = "Cuen.findByCuenfmod", query = "SELECT c FROM Cuen c WHERE c.cuenfmod = :cuenfmod")})
public class Cuen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Size(max = 8)
    @Column(name = "cuencodi")
    private String cuencodi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cuennomb")
    private String cuennomb;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenesta")
    private boolean cuenesta;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "cuen__id")
    private String cuenId;
    @Column(name = "cuennive")
    private Integer cuennive;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cuenuing")
    private String cuenuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cuenfing;
    @Size(max = 20)
    @Column(name = "cuenumod")
    private String cuenumod;
    @Column(name = "cuenfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cuenfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cuenId")
    private Collection<Puob> puobCollection;

    public Cuen() {
    }

    public Cuen(String cuenId) {
        this.cuenId = cuenId;
    }

    public Cuen(String cuenId, String cuennomb, boolean cuenesta, String cuenuing, Date cuenfing) {
        this.cuenId = cuenId;
        this.cuennomb = cuennomb;
        this.cuenesta = cuenesta;
        this.cuenuing = cuenuing;
        this.cuenfing = cuenfing;
    }

    public String getCuencodi() {
        return cuencodi;
    }

    public void setCuencodi(String cuencodi) {
        this.cuencodi = cuencodi;
    }

    public String getCuennomb() {
        return cuennomb;
    }

    public void setCuennomb(String cuennomb) {
        this.cuennomb = cuennomb;
    }

    public boolean getCuenesta() {
        return cuenesta;
    }

    public void setCuenesta(boolean cuenesta) {
        this.cuenesta = cuenesta;
    }

    public String getCuenId() {
        return cuenId;
    }

    public void setCuenId(String cuenId) {
        this.cuenId = cuenId;
    }

    public Integer getCuennive() {
        return cuennive;
    }

    public void setCuennive(Integer cuennive) {
        this.cuennive = cuennive;
    }

    public String getCuenuing() {
        return cuenuing;
    }

    public void setCuenuing(String cuenuing) {
        this.cuenuing = cuenuing;
    }

    public Date getCuenfing() {
        return cuenfing;
    }

    public void setCuenfing(Date cuenfing) {
        this.cuenfing = cuenfing;
    }

    public String getCuenumod() {
        return cuenumod;
    }

    public void setCuenumod(String cuenumod) {
        this.cuenumod = cuenumod;
    }

    public Date getCuenfmod() {
        return cuenfmod;
    }

    public void setCuenfmod(Date cuenfmod) {
        this.cuenfmod = cuenfmod;
    }

    @XmlTransient
    public Collection<Puob> getPuobCollection() {
        return puobCollection;
    }

    public void setPuobCollection(Collection<Puob> puobCollection) {
        this.puobCollection = puobCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cuenId != null ? cuenId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cuen)) {
            return false;
        }
        Cuen other = (Cuen) object;
        if ((this.cuenId == null && other.cuenId != null) || (this.cuenId != null && !this.cuenId.equals(other.cuenId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cuen[ cuenId=" + cuenId + " ]";
    }
    
}
