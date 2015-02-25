/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Cpesta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class CpestaFacade extends AbstractFacade<Cpesta> {

    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CpestaFacade() {
        super(Cpesta.class);
    }

    public void eliminarCpestas(int esta) {
        getEntityManager().createQuery("DELETE FROM Cpesta c WHERE c.estaId.estaId=" + esta + "").executeUpdate();
    }
}
