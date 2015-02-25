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
@Table(name = "sens_x_inhm", schema = "administrative")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SensXInhm.findAll", query = "SELECT s FROM SensXInhm s"),
    @NamedQuery(name = "SensXInhm.findBySensId", query = "SELECT s FROM SensXInhm s WHERE s.sensId = :sensId"),
    @NamedQuery(name = "SensXInhm.findByInhmId", query = "SELECT s FROM SensXInhm s WHERE s.inhmId = :inhmId"),
    @NamedQuery(name = "SensXInhm.findByMsenId", query = "SELECT s FROM SensXInhm s WHERE s.msenId = :msenId"),
    @NamedQuery(name = "SensXInhm.findByLiinId", query = "SELECT s FROM SensXInhm s WHERE s.liinId = :liinId"),
    @NamedQuery(name = "SensXInhm.findByMarcId", query = "SELECT s FROM SensXInhm s WHERE s.marcId = :marcId"),
    @NamedQuery(name = "SensXInhm.findByTipsId", query = "SELECT s FROM SensXInhm s WHERE s.tipsId = :tipsId"),
    @NamedQuery(name = "SensXInhm.findByInesId", query = "SELECT s FROM SensXInhm s WHERE s.inesId = :inesId"),
    @NamedQuery(name = "SensXInhm.findByInhmnomb", query = "SELECT s FROM SensXInhm s WHERE s.inhmnomb = :inhmnomb"),
    @NamedQuery(name = "SensXInhm.findByInhmmode", query = "SELECT s FROM SensXInhm s WHERE s.inhmmode = :inhmmode"),
    @NamedQuery(name = "SensXInhm.findByInhmseri", query = "SELECT s FROM SensXInhm s WHERE s.inhmseri = :inhmseri")})
public class SensXInhm implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "sens__id")
    private Integer sensId;
    @Column(name = "inhm__id")
    private Integer inhmId;
    @Column(name = "msen__id")
    private Integer msenId;
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

    public SensXInhm() {
    }

    public Integer getSensId() {
        return sensId;
    }

    public void setSensId(Integer sensId) {
        this.sensId = sensId;
    }

    public Integer getInhmId() {
        return inhmId;
    }

    public void setInhmId(Integer inhmId) {
        this.inhmId = inhmId;
    }

    public Integer getMsenId() {
        return msenId;
    }

    public void setMsenId(Integer msenId) {
        this.msenId = msenId;
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
