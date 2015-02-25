package gob.inamhi.bean;

import gob.inamhi.domain.Capto;
import gob.inamhi.session.CaptoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "captoController")
@ViewScoped
public class CaptoController extends AbstractController<Capto> implements Serializable {

    @EJB
    private CaptoFacade ejbFacade;

    public CaptoController() {
        super(Capto.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
