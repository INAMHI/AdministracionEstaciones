package gob.inamhi.bean;

import gob.inamhi.domain.Estd;
import gob.inamhi.session.EstdFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "estdController")
@ViewScoped
public class EstdController extends AbstractController<Estd> implements Serializable {

    @EJB
    private EstdFacade ejbFacade;

    public EstdController() {
        super(Estd.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
