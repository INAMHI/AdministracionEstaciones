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
@Table(name = "tipa", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipa.findAll", query = "SELECT t FROM Tipa t"),
    @NamedQuery(name = "Tipa.findByTipaId", query = "SELECT t FROM Tipa t WHERE t.tipaId = :tipaId"),
    @NamedQuery(name = "Tipa.findByTipacodi", query = "SELECT t FROM Tipa t WHERE t.tipacodi = :tipacodi"),
    @NamedQuery(name = "Tipa.findByTipanomb", query = "SELECT t FROM Tipa t WHERE t.tipanomb = :tipanomb"),
    @NamedQuery(name = "Tipa.findByTipaobse", query = "SELECT t FROM Tipa t WHERE t.tipaobse = :tipaobse"),
    @NamedQuery(name = "Tipa.findByTipauing", query = "SELECT t FROM Tipa t WHERE t.tipauing = :tipauing"),
    @NamedQuery(name = "Tipa.findByTipafing", query = "SELECT t FROM Tipa t WHERE t.tipafing = :tipafing"),
    @NamedQuery(name = "Tipa.findByTipaumod", query = "SELECT t FROM Tipa t WHERE t.tipaumod = :tipaumod"),
    @NamedQuery(name = "Tipa.findByTipafmod", query = "SELECT t FROM Tipa t WHERE t.tipafmod = :tipafmod")})
public class Tipa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipa__id")
    private Integer tipaId;
    @Size(max = 8)
    @Column(name = "tipacodi")
    private String tipacodi;
    @Size(max = 50)
    @Column(name = "tipanomb")
    private String tipanomb;
    @Size(max = 100)
    @Column(name = "tipaobse")
    private String tipaobse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipauing")
    private String tipauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tipafing;
    @Size(max = 20)
    @Column(name = "tipaumod")
    private String tipaumod;
    @Column(name = "tipafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tipafmod;

    public Tipa() {
    }

    public Tipa(Integer tipaId) {
        this.tipaId = tipaId;
    }

    public Tipa(Integer tipaId, String tipauing, Date tipafing) {
        this.tipaId = tipaId;
        this.tipauing = tipauing;
        this.tipafing = tipafing;
    }

    public Integer getTipaId() {
        return tipaId;
    }

    public void setTipaId(Integer tipaId) {
        this.tipaId = tipaId;
    }

    public String getTipacodi() {
        return tipacodi;
    }

    public void setTipacodi(String tipacodi) {
        this.tipacodi = tipacodi;
    }

    public String getTipanomb() {
        return tipanomb;
    }

    public void setTipanomb(String tipanomb) {
        this.tipanomb = tipanomb;
    }

    public String getTipaobse() {
        return tipaobse;
    }

    public void setTipaobse(String tipaobse) {
        this.tipaobse = tipaobse;
    }

    public String getTipauing() {
        return tipauing;
    }

    public void setTipauing(String tipauing) {
        this.tipauing = tipauing;
    }

    public Date getTipafing() {
        return tipafing;
    }

    public void setTipafing(Date tipafing) {
        this.tipafing = tipafing;
    }

    public String getTipaumod() {
        return tipaumod;
    }

    public void setTipaumod(String tipaumod) {
        this.tipaumod = tipaumod;
    }

    public Date getTipafmod() {
        return tipafmod;
    }

    public void setTipafmod(Date tipafmod) {
        this.tipafmod = tipafmod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipaId != null ? tipaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipa)) {
            return false;
        }
        Tipa other = (Tipa) object;
        if ((this.tipaId == null && other.tipaId != null) || (this.tipaId != null && !this.tipaId.equals(other.tipaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Tipa[ tipaId=" + tipaId + " ]";
    }
}
