package gob.inamhi.bean;

import gob.inamhi.domain.Cati;
import gob.inamhi.session.CatiFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "catiController")
@ViewScoped
public class CatiController extends AbstractController<Cati> implements Serializable {

    @EJB
    private CatiFacade ejbFacade;

    public CatiController() {
        super(Cati.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
