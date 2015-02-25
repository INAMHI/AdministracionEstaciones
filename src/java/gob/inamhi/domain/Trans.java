/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "trans", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Trans.findAll", query = "SELECT t FROM Trans t"),
    @NamedQuery(name = "Trans.findByTransId", query = "SELECT t FROM Trans t WHERE t.transId = :transId"),
    @NamedQuery(name = "Trans.findByTransdtlg", query = "SELECT t FROM Trans t WHERE t.transdtlg = :transdtlg"),
    @NamedQuery(name = "Trans.findByTrcoId", query = "SELECT t FROM Trans t WHERE t.trcoId = :trcoId"),
    @NamedQuery(name = "Trans.findByTransdtid", query = "SELECT t FROM Trans t WHERE t.transdtid = :transdtid")})
public class Trans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trans__id")
    private Integer transId;
    @Size(max = 2147483647)
    @Column(name = "transdtlg")
    private String transdtlg;
    @Size(max = 2147483647)
    @Column(name = "trco__id")
    private String trcoId;
    @Size(max = 2147483647)
    @Column(name = "transdtid")
    private String transdtid;
    @JoinColumn(name = "puob__id", referencedColumnName = "puob__id")
    @ManyToOne(optional = false)
    private Puob puobId;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne(optional = false)
    private Esta estaId;

    public Trans() {
    }

    public Trans(Integer transId) {
        this.transId = transId;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getTransdtlg() {
        return transdtlg;
    }

    public void setTransdtlg(String transdtlg) {
        this.transdtlg = transdtlg;
    }

    public String getTrcoId() {
        return trcoId;
    }

    public void setTrcoId(String trcoId) {
        this.trcoId = trcoId;
    }

    public String getTransdtid() {
        return transdtid;
    }

    public void setTransdtid(String transdtid) {
        this.transdtid = transdtid;
    }

    public Puob getPuobId() {
        return puobId;
    }

    public void setPuobId(Puob puobId) {
        this.puobId = puobId;
    }

    public Esta getEstaId() {
        return estaId;
    }

    public void setEstaId(Esta estaId) {
        this.estaId = estaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transId != null ? transId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Trans)) {
            return false;
        }
        Trans other = (Trans) object;
        if ((this.transId == null && other.transId != null) || (this.transId != null && !this.transId.equals(other.transId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Trans[ transId=" + transId + " ]";
    }
    
}
