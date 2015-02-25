/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.Parm;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class ParmFacade extends AbstractFacade<Parm> {

    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParmFacade() {
        super(Parm.class);
    }

    public List<Parm> encontrarAsignados(int tipo) {
        return getEntityManager().createQuery("SELECT t.parmId FROM Tipar t where t.tipoId.tipoId=" + tipo + "").getResultList();
    }

    public List<Parm> buscarTodosParametros() {
        return getEntityManager().createQuery("SELECT p FROM Parm p ORDER BY p.parmdesc").getResultList();
    }

    public List<Integer> buscarTodosParametrosPorTipoEstacion(int esta) {
        return getEntityManager().createQuery("SELECT v.parmId.parmId FROM VtaEstacionParametros v WHERE v.estaId=" + esta + " AND v.captoId=2").getResultList();
    }

    public List<Parm> buscarTodosParametrosPorTipoEstacionParm(int esta) {
        return getEntityManager().createQuery("SELECT v.parmId FROM VtaEstacionParametros v WHERE v.estaId=" + esta + " AND v.captoId=2").getResultList();
    }
}