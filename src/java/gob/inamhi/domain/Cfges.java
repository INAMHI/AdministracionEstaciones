/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "cfges", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cfges.findAll", query = "SELECT c FROM Cfges c"),
    @NamedQuery(name = "Cfges.findByCfgesId", query = "SELECT c FROM Cfges c WHERE c.cfgesId = :cfgesId"),
    @NamedQuery(name = "Cfges.findByCfgesalt", query = "SELECT c FROM Cfges c WHERE c.cfgesalt = :cfgesalt"),
    @NamedQuery(name = "Cfges.findByCfgesords", query = "SELECT c FROM Cfges c WHERE c.cfgesords = :cfgesords"),
    @NamedQuery(name = "Cfges.findByCfgesordd", query = "SELECT c FROM Cfges c WHERE c.cfgesordd = :cfgesordd"),
    @NamedQuery(name = "Cfges.findByCfgesfinm", query = "SELECT c FROM Cfges c WHERE c.cfgesfinm = :cfgesfinm"),
    @NamedQuery(name = "Cfges.findByCfgesffnm", query = "SELECT c FROM Cfges c WHERE c.cfgesffnm = :cfgesffnm"),
    @NamedQuery(name = "Cfges.findByCfgesdesc", query = "SELECT c FROM Cfges c WHERE c.cfgesdesc = :cfgesdesc"),
    @NamedQuery(name = "Cfges.findByCfgesuing", query = "SELECT c FROM Cfges c WHERE c.cfgesuing = :cfgesuing"),
    @NamedQuery(name = "Cfges.findByCfgesfing", query = "SELECT c FROM Cfges c WHERE c.cfgesfing = :cfgesfing"),
    @NamedQuery(name = "Cfges.findByCfgesumod", query = "SELECT c FROM Cfges c WHERE c.cfgesumod = :cfgesumod"),
    @NamedQuery(name = "Cfges.findByCfgesfmod", query = "SELECT c FROM Cfges c WHERE c.cfgesfmod = :cfgesfmod")})
public class Cfges implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cfges__id")
    private Long cfgesId;
    @Column(name = "cfgesalt")
    private BigInteger cfgesalt;
    @Column(name = "cfgesords")
    private Integer cfgesords;
    @Column(name = "cfgesordd")
    private String cfgesordd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfgesfinm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfgesfinm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfgesffnm")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfgesffnm;
    @Size(max = 1000)
    @Column(name = "cfgesdesc")
    private String cfgesdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cfgesuing")
    private String cfgesuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cfgesfing", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfgesfing;
    @Size(max = 20)
    @Column(name = "cfgesumod")
    private String cfgesumod;
    @Column(name = "cfgesfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cfgesfmod;
    @JoinColumn(name = "sens__id", referencedColumnName = "sens__id")
    @ManyToOne(optional = false)
    private Sens sensId;
    @JoinColumn(name = "esta__id", referencedColumnName = "esta__id")
    @ManyToOne(optional = false)
    private Esta estaId;
    @JoinColumn(name = "dtlg__id", referencedColumnName = "dtlg__id")
    @ManyToOne(optional = false)
    private Dtlg dtlgId;

    public Cfges() {
    }

    public Cfges(Long cfgesId) {
        this.cfgesId = cfgesId;
    }

    public Cfges(Long cfgesId, Date cfgesfinm, Date cfgesffnm, String cfgesuing, Date cfgesfing) {
        this.cfgesId = cfgesId;
        this.cfgesfinm = cfgesfinm;
        this.cfgesffnm = cfgesffnm;
        this.cfgesuing = cfgesuing;
        this.cfgesfing = cfgesfing;
    }

    public Long getCfgesId() {
        return cfgesId;
    }

    public void setCfgesId(Long cfgesId) {
        this.cfgesId = cfgesId;
    }

    public BigInteger getCfgesalt() {
        return cfgesalt;
    }

    public void setCfgesalt(BigInteger cfgesalt) {
        this.cfgesalt = cfgesalt;
    }

    public Integer getCfgesords() {
        return cfgesords;
    }

    public void setCfgesords(Integer cfgesords) {
        this.cfgesords = cfgesords;
    }

    public String getCfgesordd() {
        return cfgesordd;
    }

    public void setCfgesordd(String cfgesordd) {
        this.cfgesordd = cfgesordd;
    }

    public Date getCfgesfinm() {
        return cfgesfinm;
    }

    public void setCfgesfinm(Date cfgesfinm) {
        this.cfgesfinm = cfgesfinm;
    }

    public Date getCfgesffnm() {
        return cfgesffnm;
    }

    public void setCfgesffnm(Date cfgesffnm) {
        this.cfgesffnm = cfgesffnm;
    }

    public String getCfgesdesc() {
        return cfgesdesc;
    }

    public void setCfgesdesc(String cfgesdesc) {
        this.cfgesdesc = cfgesdesc;
    }

    public String getCfgesuing() {
        return cfgesuing;
    }

    public void setCfgesuing(String cfgesuing) {
        this.cfgesuing = cfgesuing;
    }

    public Date getCfgesfing() {
        return cfgesfing;
    }

    public void setCfgesfing(Date cfgesfing) {
        this.cfgesfing = cfgesfing;
    }

    public String getCfgesumod() {
        return cfgesumod;
    }

    public void setCfgesumod(String cfgesumod) {
        this.cfgesumod = cfgesumod;
    }

    public Date getCfgesfmod() {
        return cfgesfmod;
    }

    public void setCfgesfmod(Date cfgesfmod) {
        this.cfgesfmod = cfgesfmod;
    }

    public Sens getSensId() {
        return sensId;
    }

    public void setSensId(Sens sensId) {
        this.sensId = sensId;
    }

    public Esta getEstaId() {
        return estaId;
    }

    public void setEstaId(Esta estaId) {
        this.estaId = estaId;
    }

    public Dtlg getDtlgId() {
        return dtlgId;
    }

    public void setDtlgId(Dtlg dtlgId) {
        this.dtlgId = dtlgId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cfgesId != null ? cfgesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cfges)) {
            return false;
        }
        Cfges other = (Cfges) object;
        if ((this.cfgesId == null && other.cfgesId != null) || (this.cfgesId != null && !this.cfgesId.equals(other.cfgesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Cfges[ cfgesId=" + cfgesId + " ]";
    }
}
