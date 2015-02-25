/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "tipar", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipar.findAll", query = "SELECT t FROM Tipar t"),
    @NamedQuery(name = "Tipar.findByTiparId", query = "SELECT t FROM Tipar t WHERE t.tiparId = :tiparId"),
    @NamedQuery(name = "Tipar.findByTiparmax", query = "SELECT t FROM Tipar t WHERE t.tiparmax = :tiparmax"),
    @NamedQuery(name = "Tipar.findByTiparmin", query = "SELECT t FROM Tipar t WHERE t.tiparmin = :tiparmin")})
public class Tipar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tipar__id")
    private Integer tiparId;
    @Column(name = "tiparmax")
    private BigInteger tiparmax;
    @Column(name = "tiparmin")
    private BigInteger tiparmin;
    @JoinColumn(name = "tipo__id", referencedColumnName = "tipo__id")
    @ManyToOne(optional = false)
    private Tipo tipoId;
    @JoinColumn(name = "parm__id", referencedColumnName = "parm__id")
    @ManyToOne(optional = false)
    private Parm parmId;

    public Tipar() {
    }

    public Tipar(Integer tiparId) {
        this.tiparId = tiparId;
    }

    public Integer getTiparId() {
        return tiparId;
    }

    public void setTiparId(Integer tiparId) {
        this.tiparId = tiparId;
    }

    public BigInteger getTiparmax() {
        return tiparmax;
    }

    public void setTiparmax(BigInteger tiparmax) {
        this.tiparmax = tiparmax;
    }

    public BigInteger getTiparmin() {
        return tiparmin;
    }

    public void setTiparmin(BigInteger tiparmin) {
        this.tiparmin = tiparmin;
    }

    public Tipo getTipoId() {
        return tipoId;
    }

    public void setTipoId(Tipo tipoId) {
        this.tipoId = tipoId;
    }

    public Parm getParmId() {
        return parmId;
    }

    public void setParmId(Parm parmId) {
        this.parmId = parmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tiparId != null ? tiparId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipar)) {
            return false;
        }
        Tipar other = (Tipar) object;
        if ((this.tiparId == null && other.tiparId != null) || (this.tiparId != null && !this.tiparId.equals(other.tiparId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Tipar[ tiparId=" + tiparId + " ]";
    }
    
}
