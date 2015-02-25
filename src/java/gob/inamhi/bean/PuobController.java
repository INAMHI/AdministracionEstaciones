package gob.inamhi.bean;

import gob.inamhi.domain.Puob;
import gob.inamhi.session.PuobFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "puobController")
@ViewScoped
public class PuobController extends AbstractController<Puob> implements Serializable {

    @EJB
    private PuobFacade ejbFacade;

    public PuobController() {
        super(Puob.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
