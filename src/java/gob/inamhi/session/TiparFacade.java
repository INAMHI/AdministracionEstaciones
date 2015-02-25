/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Tipar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class TiparFacade extends AbstractFacade<Tipar> {
    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiparFacade() {
        super(Tipar.class);
    }
    
    public void eliminarTipars(int tipo) {
        getEntityManager().createQuery("DELETE FROM Tipar t WHERE t.tipoId.tipoId =" + tipo + "").executeUpdate();
    }
    
}
