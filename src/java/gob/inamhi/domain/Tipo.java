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
@Table(name = "tipo", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipo.findAll", query = "SELECT t FROM Tipo t"),
    @NamedQuery(name = "Tipo.findByTipoId", query = "SELECT t FROM Tipo t WHERE t.tipoId = :tipoId"),
    @NamedQuery(name = "Tipo.findByTiponomb", query = "SELECT t FROM Tipo t WHERE t.tiponomb = :tiponomb"),
    @NamedQuery(name = "Tipo.findByTipoobse", query = "SELECT t FROM Tipo t WHERE t.tipoobse = :tipoobse"),
    @NamedQuery(name = "Tipo.findByTipoesta", query = "SELECT t FROM Tipo t WHERE t.tipoesta = :tipoesta"),
    @NamedQuery(name = "Tipo.findByTipouing", query = "SELECT t FROM Tipo t WHERE t.tipouing = :tipouing"),
    @NamedQuery(name = "Tipo.findByTipofing", query = "SELECT t FROM Tipo t WHERE t.tipofing = :tipofing"),
    @NamedQuery(name = "Tipo.findByTipoumod", query = "SELECT t FROM Tipo t WHERE t.tipoumod = :tipoumod"),
    @NamedQuery(name = "Tipo.findByTipofmod", query = "SELECT t FROM Tipo t WHERE t.tipofmod = :tipofmod"),
    @NamedQuery(name = "Tipo.findByTipocodi", query = "SELECT t FROM Tipo t WHERE t.tipocodi = :tipocodi")})
public class Tipo implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoId")
    private Collection<Tipar> tiparCollection;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipo__id")
    private Integer tipoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tiponomb")
    private String tiponomb;
    @Size(max = 2147483647)
    @Column(name = "tipoobse")
    private String tipoobse;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipoesta")
    private boolean tipoesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "tipouing")
    private String tipouing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipofing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tipofing;
    @Size(max = 20)
    @Column(name = "tipoumod")
    private String tipoumod;
    @Column(name = "tipofmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date tipofmod;
    @Size(max = 8)
    @Column(name = "tipocodi")
    private String tipocodi;
    @JoinColumn(name = "cate__id", referencedColumnName = "cate__id")
    @ManyToOne(optional = false)
    private Cate cateId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoId")
    private Collection<Cati> catiCollection;

    public Tipo() {
    }

    public Tipo(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public Tipo(Integer tipoId, String tiponomb, boolean tipoesta, String tipouing, Date tipofing) {
        this.tipoId = tipoId;
        this.tiponomb = tiponomb;
        this.tipoesta = tipoesta;
        this.tipouing = tipouing;
        this.tipofing = tipofing;
    }

    public Integer getTipoId() {
        return tipoId;
    }

    public void setTipoId(Integer tipoId) {
        this.tipoId = tipoId;
    }

    public String getTiponomb() {
        return tiponomb;
    }

    public void setTiponomb(String tiponomb) {
        this.tiponomb = tiponomb;
    }

    public String getTipoobse() {
        return tipoobse;
    }

    public void setTipoobse(String tipoobse) {
        this.tipoobse = tipoobse;
    }

    public boolean getTipoesta() {
        return tipoesta;
    }

    public void setTipoesta(boolean tipoesta) {
        this.tipoesta = tipoesta;
    }

    public String getTipouing() {
        return tipouing;
    }

    public void setTipouing(String tipouing) {
        this.tipouing = tipouing;
    }

    public Date getTipofing() {
        return tipofing;
    }

    public void setTipofing(Date tipofing) {
        this.tipofing = tipofing;
    }

    public String getTipoumod() {
        return tipoumod;
    }

    public void setTipoumod(String tipoumod) {
        this.tipoumod = tipoumod;
    }

    public Date getTipofmod() {
        return tipofmod;
    }

    public void setTipofmod(Date tipofmod) {
        this.tipofmod = tipofmod;
    }

    public String getTipocodi() {
        return tipocodi;
    }

    public void setTipocodi(String tipocodi) {
        this.tipocodi = tipocodi;
    }

    public Cate getCateId() {
        return cateId;
    }

    public void setCateId(Cate cateId) {
        this.cateId = cateId;
    }

    @XmlTransient
    public Collection<Cati> getCatiCollection() {
        return catiCollection;
    }

    public void setCatiCollection(Collection<Cati> catiCollection) {
        this.catiCollection = catiCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoId != null ? tipoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipo)) {
            return false;
        }
        Tipo other = (Tipo) object;
        if ((this.tipoId == null && other.tipoId != null) || (this.tipoId != null && !this.tipoId.equals(other.tipoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Tipo[ tipoId=" + tipoId + " ]";
    }

    @XmlTransient
    public Collection<Tipar> getTiparCollection() {
        return tiparCollection;
    }

    public void setTiparCollection(Collection<Tipar> tiparCollection) {
        this.tiparCollection = tiparCollection;
    }
    
}
