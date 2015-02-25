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
@Table(name = "inhm", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inhm.findAll", query = "SELECT i FROM Inhm i"),
    @NamedQuery(name = "Inhm.findByInhmId", query = "SELECT i FROM Inhm i WHERE i.inhmId = :inhmId"),
    @NamedQuery(name = "Inhm.findByInhmcoda", query = "SELECT i FROM Inhm i WHERE i.inhmcoda = :inhmcoda"),
    @NamedQuery(name = "Inhm.findByInhmcoba", query = "SELECT i FROM Inhm i WHERE i.inhmcoba = :inhmcoba"),
    @NamedQuery(name = "Inhm.findByInhmnomb", query = "SELECT i FROM Inhm i WHERE i.inhmnomb = :inhmnomb"),
    @NamedQuery(name = "Inhm.findByInhmmode", query = "SELECT i FROM Inhm i WHERE i.inhmmode = :inhmmode"),
    @NamedQuery(name = "Inhm.findByInhmseri", query = "SELECT i FROM Inhm i WHERE i.inhmseri = :inhmseri"),
    @NamedQuery(name = "Inhm.findByInhmaseg", query = "SELECT i FROM Inhm i WHERE i.inhmaseg = :inhmaseg"),
    @NamedQuery(name = "Inhm.findByInhmesta", query = "SELECT i FROM Inhm i WHERE i.inhmesta = :inhmesta"),
    @NamedQuery(name = "Inhm.findByInhmobse", query = "SELECT i FROM Inhm i WHERE i.inhmobse = :inhmobse"),
    @NamedQuery(name = "Inhm.findByInhmuing", query = "SELECT i FROM Inhm i WHERE i.inhmuing = :inhmuing"),
    @NamedQuery(name = "Inhm.findByInhmfing", query = "SELECT i FROM Inhm i WHERE i.inhmfing = :inhmfing"),
    @NamedQuery(name = "Inhm.findByInhmumod", query = "SELECT i FROM Inhm i WHERE i.inhmumod = :inhmumod"),
    @NamedQuery(name = "Inhm.findByInhmfmod", query = "SELECT i FROM Inhm i WHERE i.inhmfmod = :inhmfmod")})
public class Inhm implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "inhm__id")
    private Integer inhmId;
    @Size(max = 50)
    @Column(name = "inhmcoda")
    private String inhmcoda;
    @Size(max = 50)
    @Column(name = "inhmcoba")
    private String inhmcoba;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "inhmnomb")
    private String inhmnomb;
    @Size(max = 1000)
    @Column(name = "inhmmode")
    private String inhmmode;
    @Size(max = 100)
    @Column(name = "inhmseri")
    private String inhmseri;
    @Column(name = "inhmaseg")
    private Boolean inhmaseg;
    @Lob
    @Column(name = "inhmimag")
    private byte[] inhmimag;
    @Column(name = "inhmesta")
    private Boolean inhmesta;
    @Size(max = 2147483647)
    @Column(name = "inhmobse")
    private String inhmobse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inhmuing")
    private String inhmuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inhmfing", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date inhmfing;
    @Size(max = 20)
    @Column(name = "inhmumod")
    private String inhmumod;
    @Column(name = "inhmfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inhmfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inhmId")
    private Collection<Dtlg> dtlgCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inhmId")
    private Collection<Sens> sensCollection;
    @JoinColumn(name = "tips__id", referencedColumnName = "tips__id")
    @ManyToOne(optional = false)
    private Tips tipsId;
    @JoinColumn(name = "marc__id", referencedColumnName = "marc__id")
    @ManyToOne(optional = false)
    private Marc marcId;
    @JoinColumn(name = "liin__id", referencedColumnName = "liin__id")
    @ManyToOne(optional = false)
    private Liin liinId;
    @JoinColumn(name = "ines__id", referencedColumnName = "ines__id")
    @ManyToOne(optional = false)
    private Ines inesId;

    public Inhm() {
    }

    public Inhm(Integer inhmId) {
        this.inhmId = inhmId;
    }

    public Inhm(Integer inhmId, String inhmnomb, String inhmuing, Date inhmfing) {
        this.inhmId = inhmId;
        this.inhmnomb = inhmnomb;
        this.inhmuing = inhmuing;
        this.inhmfing = inhmfing;
    }

    public Integer getInhmId() {
        return inhmId;
    }

    public void setInhmId(Integer inhmId) {
        this.inhmId = inhmId;
    }

    public String getInhmcoda() {
        return inhmcoda;
    }

    public void setInhmcoda(String inhmcoda) {
        this.inhmcoda = inhmcoda;
    }

    public String getInhmcoba() {
        return inhmcoba;
    }

    public void setInhmcoba(String inhmcoba) {
        this.inhmcoba = inhmcoba;
    }

    public String getInhmnomb() {
        return inhmnomb;
    }

    public void setInhmnomb(String inhmnomb) {
        this.inhmnomb = inhmnomb;
    }

    public String getInhmmode() {
        return inhmmode;
    }

    public void setInhmmode(String inhmmode) {
        this.inhmmode = inhmmode;
    }

    public String getInhmseri() {
        return inhmseri;
    }

    public void setInhmseri(String inhmseri) {
        this.inhmseri = inhmseri;
    }

    public Boolean getInhmaseg() {
        return inhmaseg;
    }

    public void setInhmaseg(Boolean inhmaseg) {
        this.inhmaseg = inhmaseg;
    }

    public byte[] getInhmimag() {
        return inhmimag;
    }

    public void setInhmimag(byte[] inhmimag) {
        this.inhmimag = inhmimag;
    }

    public Boolean getInhmesta() {
        return inhmesta;
    }

    public void setInhmesta(Boolean inhmesta) {
        this.inhmesta = inhmesta;
    }

    public String getInhmobse() {
        return inhmobse;
    }

    public void setInhmobse(String inhmobse) {
        this.inhmobse = inhmobse;
    }

    public String getInhmuing() {
        return inhmuing;
    }

    public void setInhmuing(String inhmuing) {
        this.inhmuing = inhmuing;
    }

    public Date getInhmfing() {
        return inhmfing;
    }

    public void setInhmfing(Date inhmfing) {
        this.inhmfing = inhmfing;
    }

    public String getInhmumod() {
        return inhmumod;
    }

    public void setInhmumod(String inhmumod) {
        this.inhmumod = inhmumod;
    }

    public Date getInhmfmod() {
        return inhmfmod;
    }

    public void setInhmfmod(Date inhmfmod) {
        this.inhmfmod = inhmfmod;
    }

    @XmlTransient
    public Collection<Dtlg> getDtlgCollection() {
        return dtlgCollection;
    }

    public void setDtlgCollection(Collection<Dtlg> dtlgCollection) {
        this.dtlgCollection = dtlgCollection;
    }

    @XmlTransient
    public Collection<Sens> getSensCollection() {
        return sensCollection;
    }

    public void setSensCollection(Collection<Sens> sensCollection) {
        this.sensCollection = sensCollection;
    }

    public Tips getTipsId() {
        return tipsId;
    }

    public void setTipsId(Tips tipsId) {
        this.tipsId = tipsId;
    }

    public Marc getMarcId() {
        return marcId;
    }

    public void setMarcId(Marc marcId) {
        this.marcId = marcId;
    }

    public Liin getLiinId() {
        return liinId;
    }

    public void setLiinId(Liin liinId) {
        this.liinId = liinId;
    }

    public Ines getInesId() {
        return inesId;
    }

    public void setInesId(Ines inesId) {
        this.inesId = inesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inhmId != null ? inhmId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inhm)) {
            return false;
        }
        Inhm other = (Inhm) object;
        if ((this.inhmId == null && other.inhmId != null) || (this.inhmId != null && !this.inhmId.equals(other.inhmId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Inhm[ inhmId=" + inhmId + " ]";
    }
}
