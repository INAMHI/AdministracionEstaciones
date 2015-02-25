/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Sens;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class SensFacade extends AbstractFacade<Sens> {

    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SensFacade() {
        super(Sens.class);
    }

    public List<Sens> encontrarDisponibles() {
        return getEntityManager().createQuery("SELECT s FROM Sens s where s.inhmId.inesId.inesId=4").getResultList();
    }

    public List<Sens> encontrarInstalados(int esta) {
        return getEntityManager().createQuery("SELECT s.sensId FROM Cfges s where s.estaId.estaId=" + esta + " and s.cfgesffnm in (SELECT max(t.cfgesffnm) FROM Cfges t where t.estaId.estaId=" + esta + " ) ORDER BY s.cfgesords").getResultList();
    }
}
