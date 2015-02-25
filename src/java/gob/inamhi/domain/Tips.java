/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "tips", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tips.findAll", query = "SELECT t FROM Tips t"),
    @NamedQuery(name = "Tips.findByTipsId", query = "SELECT t FROM Tips t WHERE t.tipsId = :tipsId"),
    @NamedQuery(name = "Tips.findByTipscodi", query = "SELECT t FROM Tips t WHERE t.tipscodi = :tipscodi"),
    @NamedQuery(name = "Tips.findByTipsnomb", query = "SELECT t FROM Tips t WHERE t.tipsnomb = :tipsnomb"),
    @NamedQuery(name = "Tips.findByTipstota", query = "SELECT t FROM Tips t WHERE t.tipstota = :tipstota"),
    @NamedQuery(name = "Tips.findByEspedesc", query = "SELECT t FROM Tips t WHERE t.espedesc = :espedesc")})
public class Tips implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tips__id")
    private Integer tipsId;
    @Size(max = 20)
    @Column(name = "tipscodi")
    private String tipscodi;
    @Size(max = 50)
    @Column(name = "tipsnomb")
    private String tipsnomb;
    @Column(name = "tipstota")
    private Integer tipstota;
    @Size(max = 2147483647)
    @Column(name = "espedesc")
    private String espedesc;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipsId")
    private Collection<Inhm> inhmCollection;

    public Tips() {
    }

    public Tips(Integer tipsId) {
        this.tipsId = tipsId;
    }

    public Integer getTipsId() {
        return tipsId;
    }

    public void setTipsId(Integer tipsId) {
        this.tipsId = tipsId;
    }

    public String getTipscodi() {
        return tipscodi;
    }

    public void setTipscodi(String tipscodi) {
        this.tipscodi = tipscodi;
    }

    public String getTipsnomb() {
        return tipsnomb;
    }

    public void setTipsnomb(String tipsnomb) {
        this.tipsnomb = tipsnomb;
    }

    public Integer getTipstota() {
        return tipstota;
    }

    public void setTipstota(Integer tipstota) {
        this.tipstota = tipstota;
    }

    public String getEspedesc() {
        return espedesc;
    }

    public void setEspedesc(String espedesc) {
        this.espedesc = espedesc;
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
        hash += (tipsId != null ? tipsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tips)) {
            return false;
        }
        Tips other = (Tips) object;
        if ((this.tipsId == null && other.tipsId != null) || (this.tipsId != null && !this.tipsId.equals(other.tipsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Tips[ tipsId=" + tipsId + " ]";
    }
    
}
