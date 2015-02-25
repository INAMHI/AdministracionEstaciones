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
@Table(name = "cate", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cate.findAll", query = "SELECT c FROM Cate c"),
    @NamedQuery(name = "Cate.findByCateId", query = "SELECT c FROM Cate c WHERE c.cateId = :cateId"),
    @NamedQuery(name = "Cate.findByCatenomb", query = "SELECT c FROM Cate c WHERE c.catenomb = :catenomb"),
    @NamedQuery(name = "Cate.findByCatedesc", query = "SELECT c FROM Cate c WHERE c.catedesc = :catedesc"),
    @NamedQuery(name = "Cate.findByCateuing", query = "SELECT c FROM Cate c WHERE c.cateuing = :cateuing"),
    @NamedQuery(name = "Cate.findByCatefing", query = "SELECT c FROM Cate c WHERE c.catefing = :catefing"),
    @NamedQuery(name = "Cate.findByCateumod", query = "SELECT c FROM Cate c WHERE c.cateumod = :cateumod"),
    @NamedQuery(name = "Cate.findByCatefmod", query = "SELECT c FROM Cate c WHERE c.catefmod = :catefmod")})
public class Cate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cate__id")
    private Integer cateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "catenomb")
    private String catenomb;
    @Size(max = 2147483647)
    @Column(name = "catedesc")
    private String catedesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cateuing")
    private String cateuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "catefing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date catefing;
    @Size(max = 20)
    @Column(name = "cateumod")
    private String cateumod;
    @Column(name = "catefmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date catefmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cateId")
    private Collection<Tipo> tipoCollection;

    public Cate() {
    }

    public Cate(Integer cateId) {
        this.cateId = cateId;
    }

    public Cate(Integer cateId, String catenomb, String cateuing, Date catefing) {
        this.cateId = cateId;
        this.catenomb = catenomb;
        this.cateuing = cateuing;
        this.catefing = catefing;
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCatenomb() {
        return catenomb;
    }

    public void setCatenomb(String catenomb) {
        this.catenomb = catenomb;
    }

    public String getCatedesc() {
        return catedesc;
    }

    public void setCatedesc(String catedesc) {
        this.catedesc = catedesc;
    }

    public String getCateuing() {
        return cateuing;
    }

    public void setCateuing(String cateuing) {
        this.cateuing = cateuing;
    }

    public Date getCatefing() {
        return catefing;
    }

    public void setCatefing(Date catefing) {
        this.catefing = catefing;
    }

    public String getCateumod() {
        return cateumod;
    }

    public void setCateumod(String cateumod) {
        this.cateumod = cateumod;
    }

    public Date getCatefmod() {
        return catefmod;
    }

    public void setCatefmod(Date catefmod) {
        this.catefmod = catefmod;
    }

    @XmlTransient
    public Collection<Tipo> getTipoCollection() {
        return tipoCollection;
    }

    public void setTipoCollection(Collection<Tipo> tipoCollection) {
        this.tipoCollection = tipoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cateId != null ? cateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cate)) {
            return false;
        }
        Cate other = (Cate) object;
        if ((this.cateId == null && other.cateId != null) || (this.cateId != null && !this.cateId.equals(other.cateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cate[ cateId=" + cateId + " ]";
    }
    
}
