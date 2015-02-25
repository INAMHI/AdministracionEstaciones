/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "dtlg_x_inhm", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtlgXInhm.findAll", query = "SELECT d FROM DtlgXInhm d"),
    @NamedQuery(name = "DtlgXInhm.findByDtlgId", query = "SELECT d FROM DtlgXInhm d WHERE d.dtlgId = :dtlgId"),
    @NamedQuery(name = "DtlgXInhm.findByInhmId", query = "SELECT d FROM DtlgXInhm d WHERE d.inhmId = :inhmId"),
    @NamedQuery(name = "DtlgXInhm.findByMdtlId", query = "SELECT d FROM DtlgXInhm d WHERE d.mdtlId = :mdtlId"),
    @NamedQuery(name = "DtlgXInhm.findByLiinId", query = "SELECT d FROM DtlgXInhm d WHERE d.liinId = :liinId"),
    @NamedQuery(name = "DtlgXInhm.findByMarcId", query = "SELECT d FROM DtlgXInhm d WHERE d.marcId = :marcId"),
    @NamedQuery(name = "DtlgXInhm.findByTipsId", query = "SELECT d FROM DtlgXInhm d WHERE d.tipsId = :tipsId"),
    @NamedQuery(name = "DtlgXInhm.findByInesId", query = "SELECT d FROM DtlgXInhm d WHERE d.inesId = :inesId"),
    @NamedQuery(name = "DtlgXInhm.findByInhmnomb", query = "SELECT d FROM DtlgXInhm d WHERE d.inhmnomb = :inhmnomb"),
    @NamedQuery(name = "DtlgXInhm.findByInhmmode", query = "SELECT d FROM DtlgXInhm d WHERE d.inhmmode = :inhmmode"),
    @NamedQuery(name = "DtlgXInhm.findByInhmseri", query = "SELECT d FROM DtlgXInhm d WHERE d.inhmseri = :inhmseri")})
public class DtlgXInhm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "dtlg__id")
    private Integer dtlgId;
    @Column(name = "inhm__id")
    private Integer inhmId;
    @Column(name = "mdtl__id")
    private Integer mdtlId;
    @Column(name = "liin__id")
    private Integer liinId;
    @Column(name = "marc__id")
    private Integer marcId;
    @Column(name = "tips__id")
    private Integer tipsId;
    @Column(name = "ines__id")
    private Integer inesId;
    @Size(max = 100)
    @Column(name = "inhmnomb")
    private String inhmnomb;
    @Size(max = 1000)
    @Column(name = "inhmmode")
    private String inhmmode;
    @Size(max = 100)
    @Column(name = "inhmseri")
    private String inhmseri;

    public DtlgXInhm() {
    }

    public Integer getDtlgId() {
        return dtlgId;
    }

    public void setDtlgId(Integer dtlgId) {
        this.dtlgId = dtlgId;
    }

    public Integer getInhmId() {
        return inhmId;
    }

    public void setInhmId(Integer inhmId) {
        this.inhmId = inhmId;
    }

    public Integer getMdtlId() {
        return mdtlId;
    }

    public void setMdtlId(Integer mdtlId) {
        this.mdtlId = mdtlId;
    }

    public Integer getLiinId() {
        return liinId;
    }

    public void setLiinId(Integer liinId) {
        this.liinId = liinId;
    }

    public Integer getMarcId() {
        return marcId;
    }

    public void setMarcId(Integer marcId) {
        this.marcId = marcId;
    }

    public Integer getTipsId() {
        return tipsId;
    }

    public void setTipsId(Integer tipsId) {
        this.tipsId = tipsId;
    }

    public Integer getInesId() {
        return inesId;
    }

    public void setInesId(Integer inesId) {
        this.inesId = inesId;
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
    
}
