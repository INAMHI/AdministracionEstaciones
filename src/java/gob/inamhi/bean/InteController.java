package gob.inamhi.bean;

import gob.inamhi.domain.Inte;
import gob.inamhi.session.InteFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "inteController")
@ViewScoped
public class InteController extends AbstractController<Inte> implements Serializable {

    @EJB
    private InteFacade ejbFacade;

    public InteController() {
        super(Inte.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
