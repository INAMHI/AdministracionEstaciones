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
@Table(name = "copa", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Copa.findAll", query = "SELECT c FROM Copa c"),
    @NamedQuery(name = "Copa.findByCopaId", query = "SELECT c FROM Copa c WHERE c.copaId = :copaId"),
    @NamedQuery(name = "Copa.findByCopadesc", query = "SELECT c FROM Copa c WHERE c.copadesc = :copadesc"),
    @NamedQuery(name = "Copa.findByCopanemo", query = "SELECT c FROM Copa c WHERE c.copanemo = :copanemo"),
    @NamedQuery(name = "Copa.findByCopauing", query = "SELECT c FROM Copa c WHERE c.copauing = :copauing"),
    @NamedQuery(name = "Copa.findByCopafing", query = "SELECT c FROM Copa c WHERE c.copafing = :copafing"),
    @NamedQuery(name = "Copa.findByCopaumod", query = "SELECT c FROM Copa c WHERE c.copaumod = :copaumod"),
    @NamedQuery(name = "Copa.findByCopafmod", query = "SELECT c FROM Copa c WHERE c.copafmod = :copafmod")})
public class Copa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "copa__id")
    private Integer copaId;
    @Size(max = 1000)
    @Column(name = "copadesc")
    private String copadesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "copanemo")
    private String copanemo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "copauing")
    private String copauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "copafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date copafing;
    @Size(max = 20)
    @Column(name = "copaumod")
    private String copaumod;
    @Column(name = "copafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date copafmod;
    @JoinColumn(name = "umep__id", referencedColumnName = "umep__id")
    @ManyToOne(optional = false)
    private Umep umepId;
    @JoinColumn(name = "parm__id", referencedColumnName = "parm__id")
    @ManyToOne(optional = false)
    private Parm parmId;
    @JoinColumn(name = "inut__id", referencedColumnName = "inut__id")
    @ManyToOne(optional = false)
    private Inut inutId;
    @JoinColumn(name = "estd__id", referencedColumnName = "estd__id")
    @ManyToOne(optional = false)
    private Estd estdId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "copaId")
    private Collection<Cpesta> cpestaCollection;

    public Copa() {
    }

    public Copa(Integer copaId) {
        this.copaId = copaId;
    }

    public Copa(Integer copaId, String copanemo, String copauing, Date copafing) {
        this.copaId = copaId;
        this.copanemo = copanemo;
        this.copauing = copauing;
        this.copafing = copafing;
    }

    public Integer getCopaId() {
        return copaId;
    }

    public void setCopaId(Integer copaId) {
        this.copaId = copaId;
    }

    public String getCopadesc() {
        return copadesc;
    }

    public void setCopadesc(String copadesc) {
        this.copadesc = copadesc;
    }

    public String getCopanemo() {
        return copanemo;
    }

    public void setCopanemo(String copanemo) {
        this.copanemo = copanemo;
    }

    public String getCopauing() {
        return copauing;
    }

    public void setCopauing(String copauing) {
        this.copauing = copauing;
    }

    public Date getCopafing() {
        return copafing;
    }

    public void setCopafing(Date copafing) {
        this.copafing = copafing;
    }

    public String getCopaumod() {
        return copaumod;
    }

    public void setCopaumod(String copaumod) {
        this.copaumod = copaumod;
    }

    public Date getCopafmod() {
        return copafmod;
    }

    public void setCopafmod(Date copafmod) {
        this.copafmod = copafmod;
    }

    public Umep getUmepId() {
        return umepId;
    }

    public void setUmepId(Umep umepId) {
        this.umepId = umepId;
    }

    public Parm getParmId() {
        return parmId;
    }

    public void setParmId(Parm parmId) {
        this.parmId = parmId;
    }

    public Inut getInutId() {
        return inutId;
    }

    public void setInutId(Inut inutId) {
        this.inutId = inutId;
    }

    public Estd getEstdId() {
        return estdId;
    }

    public void setEstdId(Estd estdId) {
        this.estdId = estdId;
    }

    @XmlTransient
    public Collection<Cpesta> getCpestaCollection() {
        return cpestaCollection;
    }

    public void setCpestaCollection(Collection<Cpesta> cpestaCollection) {
        this.cpestaCollection = cpestaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (copaId != null ? copaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Copa)) {
            return false;
        }
        Copa other = (Copa) object;
        if ((this.copaId == null && other.copaId != null) || (this.copaId != null && !this.copaId.equals(other.copaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Copa[ copaId=" + copaId + " ]";
    }
    
}
