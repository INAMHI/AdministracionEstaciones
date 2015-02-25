/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Copa;
import gob.inamhi.domain.Parm;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class CopaFacade extends AbstractFacade<Copa> {

    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CopaFacade() {
        super(Copa.class);
    }

    public List<Copa> encontrarAsignados(int esta) {
        return getEntityManager().createQuery("SELECT c.copaId FROM Cpesta c where c.estaId.estaId=" + esta + "").getResultList();
    }

    public List<Copa> buscarTodosCopas() {
        return getEntityManager().createQuery("SELECT c FROM Copa c ORDER BY c.parmId.parmdesc").getResultList();
    }

    public List<Copa> buscarTodosCopasPorParm(List<Integer> parametros) {

        Query q = getEntityManager().createQuery("SELECT c FROM Copa c WHERE c.parmId.parmId IN :inclList ORDER BY c.parmId.parmdesc");
        q.setParameter("inclList", parametros);
        return q.getResultList();
    }
}
