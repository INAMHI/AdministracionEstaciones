/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Esta;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class EstaFacade extends AbstractFacade<Esta> {

    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EstaFacade() {
        super(Esta.class);
    }

    public List<Esta> ListarEstaciones() {
        return getEntityManager().createQuery("SELECT e FROM Esta e WHERE e.catiId.captoId.captoId=2 ORDER BY e.estaId ").getResultList();
    }
}
