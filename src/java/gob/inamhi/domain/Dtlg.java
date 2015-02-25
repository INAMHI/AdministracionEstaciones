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
@Table(name = "dtlg", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dtlg.findAll", query = "SELECT d FROM Dtlg d"),
    @NamedQuery(name = "Dtlg.findByDtlgId", query = "SELECT d FROM Dtlg d WHERE d.dtlgId = :dtlgId")})
public class Dtlg implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dtlg__id")
    private Integer dtlgId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dtlgId")
    private Collection<Cfges> cfgesCollection;
    @JoinColumn(name = "inhm__id", referencedColumnName = "inhm__id")
    @ManyToOne(optional = false)
    private Inhm inhmId;

    public Dtlg() {
    }

    public Dtlg(Integer dtlgId) {
        this.dtlgId = dtlgId;
    }

    public Integer getDtlgId() {
        return dtlgId;
    }

    public void setDtlgId(Integer dtlgId) {
        this.dtlgId = dtlgId;
    }

    @XmlTransient
    public Collection<Cfges> getCfgesCollection() {
        return cfgesCollection;
    }

    public void setCfgesCollection(Collection<Cfges> cfgesCollection) {
        this.cfgesCollection = cfgesCollection;
    }

    public Inhm getInhmId() {
        return inhmId;
    }

    public void setInhmId(Inhm inhmId) {
        this.inhmId = inhmId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dtlgId != null ? dtlgId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dtlg)) {
            return false;
        }
        Dtlg other = (Dtlg) object;
        if ((this.dtlgId == null && other.dtlgId != null) || (this.dtlgId != null && !this.dtlgId.equals(other.dtlgId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Dtlg[ dtlgId=" + dtlgId + " ]";
    }
    
}
