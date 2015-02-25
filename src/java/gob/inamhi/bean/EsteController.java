package gob.inamhi.bean;

import gob.inamhi.domain.Este;
import gob.inamhi.session.EsteFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "esteController")
@ViewScoped
public class EsteController extends AbstractController<Este> implements Serializable {

    @EJB
    private EsteFacade ejbFacade;

    public EsteController() {
        super(Este.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
