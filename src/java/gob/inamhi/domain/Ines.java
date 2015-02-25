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
@Table(name = "ines", schema="administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ines.findAll", query = "SELECT i FROM Ines i"),
    @NamedQuery(name = "Ines.findByInesId", query = "SELECT i FROM Ines i WHERE i.inesId = :inesId"),
    @NamedQuery(name = "Ines.findByInesnomb", query = "SELECT i FROM Ines i WHERE i.inesnomb = :inesnomb"),
    @NamedQuery(name = "Ines.findByInesdesc", query = "SELECT i FROM Ines i WHERE i.inesdesc = :inesdesc"),
    @NamedQuery(name = "Ines.findByInesuing", query = "SELECT i FROM Ines i WHERE i.inesuing = :inesuing"),
    @NamedQuery(name = "Ines.findByInesfing", query = "SELECT i FROM Ines i WHERE i.inesfing = :inesfing"),
    @NamedQuery(name = "Ines.findByInesumod", query = "SELECT i FROM Ines i WHERE i.inesumod = :inesumod"),
    @NamedQuery(name = "Ines.findByInesfmod", query = "SELECT i FROM Ines i WHERE i.inesfmod = :inesfmod")})
public class Ines implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ines__id")
    private Integer inesId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "inesnomb")
    private String inesnomb;
    @Size(max = 2147483647)
    @Column(name = "inesdesc")
    private String inesdesc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inesuing")
    private String inesuing;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inesfing")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inesfing;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "inesumod")
    private String inesumod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inesfmod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inesfmod;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inesId")
    private Collection<Inhm> inhmCollection;

    public Ines() {
    }

    public Ines(Integer inesId) {
        this.inesId = inesId;
    }

    public Ines(Integer inesId, String inesnomb, String inesuing, Date inesfing, String inesumod, Date inesfmod) {
        this.inesId = inesId;
        this.inesnomb = inesnomb;
        this.inesuing = inesuing;
        this.inesfing = inesfing;
        this.inesumod = inesumod;
        this.inesfmod = inesfmod;
    }

    public Integer getInesId() {
        return inesId;
    }

    public void setInesId(Integer inesId) {
        this.inesId = inesId;
    }

    public String getInesnomb() {
        return inesnomb;
    }

    public void setInesnomb(String inesnomb) {
        this.inesnomb = inesnomb;
    }

    public String getInesdesc() {
        return inesdesc;
    }

    public void setInesdesc(String inesdesc) {
        this.inesdesc = inesdesc;
    }

    public String getInesuing() {
        return inesuing;
    }

    public void setInesuing(String inesuing) {
        this.inesuing = inesuing;
    }

    public Date getInesfing() {
        return inesfing;
    }

    public void setInesfing(Date inesfing) {
        this.inesfing = inesfing;
    }

    public String getInesumod() {
        return inesumod;
    }

    public void setInesumod(String inesumod) {
        this.inesumod = inesumod;
    }

    public Date getInesfmod() {
        return inesfmod;
    }

    public void setInesfmod(Date inesfmod) {
        this.inesfmod = inesfmod;
    }

    @XmlTransient
    public Collection<Inhm> getInhmCollection() {
        return inhmCollection;
    }

    public void setInhmCollection(Collection<Inhm> inhmCollection) {
        this.inhmCollection = inhmCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (inesId != null ? inesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ines)) {
            return false;
        }
        Ines other = (Ines) object;
        if ((this.inesId == null && other.inesId != null) || (this.inesId != null && !this.inesId.equals(other.inesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gob.inamhi.domain.Ines[ inesId=" + inesId + " ]";
    }
    
}
