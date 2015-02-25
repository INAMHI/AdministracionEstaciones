package gob.inamhi.bean;

import gob.inamhi.domain.SensXInhm;
import gob.inamhi.session.SensXInhmFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "sensXInhmController")
@SessionScoped
public class SensXInhmController extends AbstractController<SensXInhm> implements Serializable {

    @EJB
    private SensXInhmFacade ejbFacade;

    public SensXInhmController() {
        super(SensXInhm.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
