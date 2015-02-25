package gob.inamhi.bean;

import gob.inamhi.domain.Proes;
import gob.inamhi.session.ProesFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "proesController")
@ViewScoped
public class ProesController extends AbstractController<Proes> implements Serializable {

    @EJB
    private ProesFacade ejbFacade;

    public ProesController() {
        super(Proes.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
