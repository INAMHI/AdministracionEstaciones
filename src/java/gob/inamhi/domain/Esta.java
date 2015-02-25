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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dhinojosa
 */
@Entity
@Table(name = "esta", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Esta.findAll", query = "SELECT e FROM Esta e"),
    @NamedQuery(name = "Esta.findByEstaId", query = "SELECT e FROM Esta e WHERE e.estaId = :estaId"),
    @NamedQuery(name = "Esta.findByEstafein", query = "SELECT e FROM Esta e WHERE e.estafein = :estafein"),
    @NamedQuery(name = "Esta.findByEstafele", query = "SELECT e FROM Esta e WHERE e.estafele = :estafele"),
    @NamedQuery(name = "Esta.findByEstaobse", query = "SELECT e FROM Esta e WHERE e.estaobse = :estaobse"),
    @NamedQuery(name = "Esta.findByEstainfo", query = "SELECT e FROM Esta e WHERE e.estainfo = :estainfo"),
    @NamedQuery(name = "Esta.findByEstadtlg", query = "SELECT e FROM Esta e WHERE e.estadtlg = :estadtlg"),
    @NamedQuery(name = "Esta.findByEstavin", query = "SELECT e FROM Esta e WHERE e.estavin = :estavin"),
    @NamedQuery(name = "Esta.findByEstavex", query = "SELECT e FROM Esta e WHERE e.estavex = :estavex"),
    @NamedQuery(name = "Esta.findByEstauing", query = "SELECT e FROM Esta e WHERE e.estauing = :estauing"),
    @NamedQuery(name = "Esta.findByEstafing", query = "SELECT e FROM Esta e WHERE e.estafing = :estafing"),
    @NamedQuery(name = "Esta.findByEstaumod", query = "SELECT e FROM Esta e WHERE e.estaumod = :estaumod"),
    @NamedQuery(name = "Esta.findByEstafmod", query = "SELECT e FROM Esta e WHERE e.estafmod = :estafmod")})
public class Esta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "esta__id")
    private Integer estaId;
    @Column(name = "estafein")
    @Temporal(TemporalType.DATE)
    private Date estafein;
    @Column(name = "estafele")
    @Temporal(TemporalType.DATE)
    private Date estafele;
    @Size(max = 2147483647)
    @Column(name = "estaobse")
    private String estaobse;
    @Size(max = 2147483647)
    @Column(name = "estainfo")
    private String estainfo;
    @Size(max = 2147483647)
    @Column(name = "estadtlg")
    private String estadtlg;
    @Lob
    @Column(name = "estaimgn")
    private byte[] estaimgn;
    @Lob
    @Column(name = "estaimgs")
    private byte[] estaimgs;
    @Lob
    @Column(name = "estaimge")
    private byte[] estaimge;
    @Lob
    @Column(name = "estaimgo")
    private byte[] estaimgo;
    @Column(name = "estavin")
    private Boolean estavin;
    @Column(name = "estavex")
    private Boolean estavex;
    @Size(max = 2147483647)
    @Column(name = "estauing")
    private String estauing;
    @Column(name = "estafing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estafing;
    @Size(max = 2147483647)
    @Column(name = "estaumod")
    private String estaumod;
    @Column(name = "estafmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date estafmod;
    @JoinColumn(name = "puob__id", referencedColumnName = "puob__id")
    @ManyToOne(optional = false)
    private Puob puobId;
    @JoinColumn(name = "proes__id", referencedColumnName = "proes__id")
    @ManyToOne(optional = false)
    private Proes proesId;
    @JoinColumn(name = "este__id", referencedColumnName = "este__id")
    @ManyToOne(optional = false)
    private Este esteId;
    @JoinColumn(name = "cati__id", referencedColumnName = "cati__id")
    @ManyToOne(optional = false)
    private Cati catiId;

    public Esta() {
    }

    public Esta(Integer estaId) {
        this.estaId = estaId;
    }

    public Integer getEstaId() {
        return estaId;
    }

    public void setEstaId(Integer estaId) {
        this.estaId = estaId;
    }

    public Date getEstafein() {
        return estafein;
    }

    public void setEstafein(Date estafein) {
        this.estafein = estafein;
    }

    public Date getEstafele() {
        return estafele;
    }

    public void setEstafele(Date estafele) {
        this.estafele = estafele;
    }

    public String getEstaobse() {
        return estaobse;
    }

    public void setEstaobse(String estaobse) {
        this.estaobse = estaobse;
    }

    public String getEstainfo() {
        return estainfo;
    }

    public void setEstainfo(String estainfo) {
        this.estainfo = estainfo;
    }

    public String getEstadtlg() {
        return estadtlg;
    }

    public void setEstadtlg(String estadtlg) {
        this.estadtlg = estadtlg;
    }

    public byte[] getEstaimgn() {
        return estaimgn;
    }

    public void setEstaimgn(byte[] estaimgn) {
        this.estaimgn = estaimgn;
    }

    public byte[] getEstaimgs() {
        return estaimgs;
    }

    public void setEstaimgs(byte[] estaimgs) {
        this.estaimgs = estaimgs;
    }

    public byte[] getEstaimge() {
        return estaimge;
    }

    public void setEstaimge(byte[] estaimge) {
        this.estaimge = estaimge;
    }

    public byte[] getEstaimgo() {
        return estaimgo;
    }

    public void setEstaimgo(byte[] estaimgo) {
        this.estaimgo = estaimgo;
    }

    public Boolean getEstavin() {
        return estavin;
    }

    public void setEstavin(Boolean estavin) {
        this.estavin = estavin;
    }

    public Boolean getEstavex() {
        return estavex;
    }

    public void setEstavex(Boolean estavex) {
        this.estavex = estavex;
    }

    public String getEstauing() {
        return estauing;
    }

    public void setEstauing(String estauing) {
        this.estauing = estauing;
    }

    public Date getEstafing() {
        return estafing;
    }

    public void setEstafing(Date estafing) {
        this.estafing = estafing;
    }

    public String getEstaumod() {
        return estaumod;
    }

    public void setEstaumod(String estaumod) {
        this.estaumod = estaumod;
    }

    public Date getEstafmod() {
        return estafmod;
    }

    public void setEstafmod(Date estafmod) {
        this.estafmod = estafmod;
    }

    public Puob getPuobId() {
        return puobId;
    }

    public void setPuobId(Puob puobId) {
        this.puobId = puobId;
    }

    public Proes getProesId() {
        return proesId;
    }

    public void setProesId(Proes proesId) {
        this.proesId = proesId;
    }

    public Este getEsteId() {
        return esteId;
    }

    public void setEsteId(Este esteId) {
        this.esteId = esteId;
    }

    public Cati getCatiId() {
        return catiId;
    }

    public void setCatiId(Cati catiId) {
        this.catiId = catiId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estaId != null ? estaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Esta)) {
            return false;
        }
        Esta other = (Esta) object;
        if ((this.estaId == null && other.estaId != null) || (this.estaId != null && !this.estaId.equals(other.estaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Esta[ estaId=" + estaId + " ]";
    }
}
