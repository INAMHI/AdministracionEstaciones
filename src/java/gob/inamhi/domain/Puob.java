/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.Lob;
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
@Table(name = "puob", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Puob.findAll", query = "SELECT p FROM Puob p"),
    @NamedQuery(name = "Puob.findByPuobId", query = "SELECT p FROM Puob p WHERE p.puobId = :puobId"),
    @NamedQuery(name = "Puob.findByPuobcodi", query = "SELECT p FROM Puob p WHERE p.puobcodi = :puobcodi"),
    @NamedQuery(name = "Puob.findByPuobnomb", query = "SELECT p FROM Puob p WHERE p.puobnomb = :puobnomb"),
    @NamedQuery(name = "Puob.findByPuobdire", query = "SELECT p FROM Puob p WHERE p.puobdire = :puobdire"),
    @NamedQuery(name = "Puob.findByPuobarea", query = "SELECT p FROM Puob p WHERE p.puobarea = :puobarea"),
    @NamedQuery(name = "Puob.findByPuobobse", query = "SELECT p FROM Puob p WHERE p.puobobse = :puobobse"),
    @NamedQuery(name = "Puob.findByPuobesta", query = "SELECT p FROM Puob p WHERE p.puobesta = :puobesta"),
    @NamedQuery(name = "Puob.findByPuobuing", query = "SELECT p FROM Puob p WHERE p.puobuing = :puobuing"),
    @NamedQuery(name = "Puob.findByPuobfing", query = "SELECT p FROM Puob p WHERE p.puobfing = :puobfing"),
    @NamedQuery(name = "Puob.findByPuobumod", query = "SELECT p FROM Puob p WHERE p.puobumod = :puobumod"),
    @NamedQuery(name = "Puob.findByPuobfmod", query = "SELECT p FROM Puob p WHERE p.puobfmod = :puobfmod")})
public class Puob implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "puob__id")
    private Integer puobId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "puobcodi")
    private String puobcodi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "puobnomb")
    private String puobnomb;
    @Size(max = 2147483647)
    @Column(name = "puobdire")
    private String puobdire;
    @Column(name = "puobarea")
    private BigInteger puobarea;
    @Size(max = 2147483647)
    @Column(name = "puobobse")
    private String puobobse;
    @Lob
    @Column(name = "puobimgn")
    private byte[] puobimgn;
    @Lob
    @Column(name = "puobimgs")
    private byte[] puobimgs;
    @Lob
    @Column(name = "puobimge")
    private byte[] puobimge;
    @Lob
    @Column(name = "puobimgo")
    private byte[] puobimgo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puobesta")
    private boolean puobesta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "puobuing")
    private String puobuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "puobfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date puobfing;
    @Size(max = 20)
    @Column(name = "puobumod")
    private String puobumod;
    @Column(name = "puobfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date puobfmod;
    @JoinColumn(name = "parr__id", referencedColumnName = "parr__id")
    @ManyToOne(optional = false)
    private Parr parrId;
    @JoinColumn(name = "maces__id", referencedColumnName = "maces__id")
    @ManyToOne(optional = false)
    private Maces macesId;
    @JoinColumn(name = "cuen__id", referencedColumnName = "cuen__id")
    @ManyToOne(optional = false)
    private Cuen cuenId;
    @JoinColumn(name = "acces__id", referencedColumnName = "acces__id")
    @ManyToOne(optional = false)
    private Acces accesId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puobId")
    private Collection<Trans> transCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puobId")
    private Collection<Esta> estaCollection;

    public Puob() {
    }

    public Puob(Integer puobId) {
        this.puobId = puobId;
    }

    public Puob(Integer puobId, String puobcodi, String puobnomb, boolean puobesta, String puobuing, Date puobfing) {
        this.puobId = puobId;
        this.puobcodi = puobcodi;
        this.puobnomb = puobnomb;
        this.puobesta = puobesta;
        this.puobuing = puobuing;
        this.puobfing = puobfing;
    }

    public Integer getPuobId() {
        return puobId;
    }

    public void setPuobId(Integer puobId) {
        this.puobId = puobId;
    }

    public String getPuobcodi() {
        return puobcodi;
    }

    public void setPuobcodi(String puobcodi) {
        this.puobcodi = puobcodi;
    }

    public String getPuobnomb() {
        return puobnomb;
    }

    public void setPuobnomb(String puobnomb) {
        this.puobnomb = puobnomb;
    }

    public String getPuobdire() {
        return puobdire;
    }

    public void setPuobdire(String puobdire) {
        this.puobdire = puobdire;
    }

    public BigInteger getPuobarea() {
        return puobarea;
    }

    public void setPuobarea(BigInteger puobarea) {
        this.puobarea = puobarea;
    }

    public String getPuobobse() {
        return puobobse;
    }

    public void setPuobobse(String puobobse) {
        this.puobobse = puobobse;
    }

    public byte[] getPuobimgn() {
        return puobimgn;
    }

    public void setPuobimgn(byte[] puobimgn) {
        this.puobimgn = puobimgn;
    }

    public byte[] getPuobimgs() {
        return puobimgs;
    }

    public void setPuobimgs(byte[] puobimgs) {
        this.puobimgs = puobimgs;
    }

    public byte[] getPuobimge() {
        return puobimge;
    }

    public void setPuobimge(byte[] puobimge) {
        this.puobimge = puobimge;
    }

    public byte[] getPuobimgo() {
        return puobimgo;
    }

    public void setPuobimgo(byte[] puobimgo) {
        this.puobimgo = puobimgo;
    }

    public boolean getPuobesta() {
        return puobesta;
    }

    public void setPuobesta(boolean puobesta) {
        this.puobesta = puobesta;
    }

    public String getPuobuing() {
        return puobuing;
    }

    public void setPuobuing(String puobuing) {
        this.puobuing = puobuing;
    }

    public Date getPuobfing() {
        return puobfing;
    }

    public void setPuobfing(Date puobfing) {
        this.puobfing = puobfing;
    }

    public String getPuobumod() {
        return puobumod;
    }

    public void setPuobumod(String puobumod) {
        this.puobumod = puobumod;
    }

    public Date getPuobfmod() {
        return puobfmod;
    }

    public void setPuobfmod(Date puobfmod) {
        this.puobfmod = puobfmod;
    }

    public Parr getParrId() {
        return parrId;
    }

    public void setParrId(Parr parrId) {
        this.parrId = parrId;
    }

    public Maces getMacesId() {
        return macesId;
    }

    public void setMacesId(Maces macesId) {
        this.macesId = macesId;
    }

    public Cuen getCuenId() {
        return cuenId;
    }

    public void setCuenId(Cuen cuenId) {
        this.cuenId = cuenId;
    }

    public Acces getAccesId() {
        return accesId;
    }

    public void setAccesId(Acces accesId) {
        this.accesId = accesId;
    }

    @XmlTransient
    public Collection<Trans> getTransCollection() {
        return transCollection;
    }

    public void setTransCollection(Collection<Trans> transCollection) {
        this.transCollection = transCollection;
    }

    @XmlTransient
    public Collection<Esta> getEstaCollection() {
        return estaCollection;
    }

    public void setEstaCollection(Collection<Esta> estaCollection) {
        this.estaCollection = estaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (puobId != null ? puobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puob)) {
            return false;
        }
        Puob other = (Puob) object;
        if ((this.puobId == null && other.puobId != null) || (this.puobId != null && !this.puobId.equals(other.puobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Puob[ puobId=" + puobId + " ]";
    }
    
}
