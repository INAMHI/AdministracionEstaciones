package gob.inamhi.bean;

import gob.inamhi.domain.DtlgXInhm;
import gob.inamhi.session.DtlgXInhmFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "dtlgXInhmController")
@SessionScoped
public class DtlgXInhmController extends AbstractController<DtlgXInhm> implements Serializable {

    @EJB
    private DtlgXInhmFacade ejbFacade;

    public DtlgXInhmController() {
        super(DtlgXInhm.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
