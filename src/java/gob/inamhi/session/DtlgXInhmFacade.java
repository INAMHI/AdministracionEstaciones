/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gob.inamhi.session;

import gob.inamhi.domain.DtlgXInhm;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dhinojosa
 */
@Stateless
public class DtlgXInhmFacade extends AbstractFacade<DtlgXInhm> {
    @PersistenceContext(unitName = "AdministracionEstacionesPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DtlgXInhmFacade() {
        super(DtlgXInhm.class);
    }
    
}
