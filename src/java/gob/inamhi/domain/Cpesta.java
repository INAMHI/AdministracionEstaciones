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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "cpesta", schema = "processed_data")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cpesta.findAll", query = "SELECT c FROM Cpesta c"),
    @NamedQuery(name = "Cpesta.findByCpestaId", query = "SELECT c FROM Cpesta c WHERE c.cpestaId = :cpestaId"),
    @NamedQuery(name = "Cpesta.findByCpestadesc", query = "SELECT c FROM Cpesta c WHERE c.cpestadesc = :cpestadesc"),
    @NamedQuery(name = "Cpesta.findByCpestauing", query = "SELECT c FROM Cpesta c WHERE c.cpestauing = :cpestauing"),
    @NamedQuery(name = "Cpesta.findByCpestafing", query = "SELECT c FROM Cpesta c WHERE c.cpestafing = :cpestafing"),
    @NamedQuery(name = "Cpesta.findByCpestaumod", query = "SELECT c FROM Cpesta c WHERE c.cpestaumod = :cpestaumod"),
    @NamedQuery(name = "Cpesta.findByCpestafmod", query = "SELECT c FROM Cpesta c WHERE c.cpestafmod = :cpestafmod")})
public class Cpesta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cpesta__id")
    private Integer cpestaId;
    @Size(max = 1000)
    @Column(name = "cpestadesc")
    private String cpestadesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cpestauing")
    private String cpestauing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpestafing", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpestafing;
    @Size(max = 20)
    @Column(name = "cpestaumod")
    private String cpestaumod;
    @Column(name = "cpestafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cpestafmod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cpestaesta")
    private boolean cpestaesta;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne
    private Esta estaId;
    @JoinColumn(name = "copa__id", referencedColumnName = "copa__id")
    @ManyToOne(optional = false)
    private Copa copaId;

    public Cpesta() {
    }

    public Cpesta(Integer cpestaId) {
        this.cpestaId = cpestaId;
    }

    public Cpesta(Integer cpestaId, String cpestauing, Date cpestafing) {
        this.cpestaId = cpestaId;
        this.cpestauing = cpestauing;
        this.cpestafing = cpestafing;
    }

    public Integer getCpestaId() {
        return cpestaId;
    }

    public void setCpestaId(Integer cpestaId) {
        this.cpestaId = cpestaId;
    }

    public String getCpestadesc() {
        return cpestadesc;
    }

    public void setCpestadesc(String cpestadesc) {
        this.cpestadesc = cpestadesc;
    }

    public String getCpestauing() {
        return cpestauing;
    }

    public void setCpestauing(String cpestauing) {
        this.cpestauing = cpestauing;
    }

    public Date getCpestafing() {
        return cpestafing;
    }

    public void setCpestafing(Date cpestafing) {
        this.cpestafing = cpestafing;
    }

    public String getCpestaumod() {
        return cpestaumod;
    }

    public void setCpestaumod(String cpestaumod) {
        this.cpestaumod = cpestaumod;
    }

    public Date getCpestafmod() {
        return cpestafmod;
    }

    public void setCpestafmod(Date cpestafmod) {
        this.cpestafmod = cpestafmod;
    }

    public boolean getCpestaesta() {
        return cpestaesta;
    }

    public void setCpestaesta(boolean cpestaesta) {
        this.cpestaesta = cpestaesta;
    }

    public Esta getEstaId() {
        return estaId;
    }

    public void setEstaId(Esta estaId) {
        this.estaId = estaId;
    }

    public Copa getCopaId() {
        return copaId;
    }

    public void setCopaId(Copa copaId) {
        this.copaId = copaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cpestaId != null ? cpestaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cpesta)) {
            return false;
        }
        Cpesta other = (Cpesta) object;
        if ((this.cpestaId == null && other.cpestaId != null) || (this.cpestaId != null && !this.cpestaId.equals(other.cpestaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cpesta[ cpestaId=" + cpestaId + " ]";
    }
}
