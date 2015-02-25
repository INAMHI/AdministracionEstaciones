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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "cati", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cati.findAll", query = "SELECT c FROM Cati c"),
    @NamedQuery(name = "Cati.findByCatiId", query = "SELECT c FROM Cati c WHERE c.catiId = :catiId")})
public class Cati implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cati__id")
    private Integer catiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catiId")
    private Collection<Escat> escatCollection;
    @JoinColumn(name = "tipo__id", referencedColumnName = "tipo__id")
    @ManyToOne(optional = false)
    private Tipo tipoId;
    @JoinColumn(name = "capto__id", referencedColumnName = "capto__id")
    @ManyToOne(optional = false)
    private Capto captoId;

    public Cati() {
    }

    public Cati(Integer catiId) {
        this.catiId = catiId;
    }

    public Integer getCatiId() {
        return catiId;
    }

    public void setCatiId(Integer catiId) {
        this.catiId = catiId;
    }

    @XmlTransient
    public Collection<Escat> getEscatCollection() {
        return escatCollection;
    }

    public void setEscatCollection(Collection<Escat> escatCollection) {
        this.escatCollection = escatCollection;
    }

    public Tipo getTipoId() {
        return tipoId;
    }

    public void setTipoId(Tipo tipoId) {
        this.tipoId = tipoId;
    }

    public Capto getCaptoId() {
        return captoId;
    }

    public void setCaptoId(Capto captoId) {
        this.captoId = captoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catiId != null ? catiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cati)) {
            return false;
        }
        Cati other = (Cati) object;
        if ((this.catiId == null && other.catiId != null) || (this.catiId != null && !this.catiId.equals(other.catiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cati[ catiId=" + catiId + " ]";
    }
    
}
