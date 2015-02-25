package gob.inamhi.bean;

import gob.inamhi.domain.Tipa;
import gob.inamhi.session.TipaFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

@Named(value = "tipaController")
@SessionScoped
public class TipaController extends AbstractController<Tipa> implements Serializable {

    @EJB
    private TipaFacade ejbFacade;

    public TipaController() {
        super(Tipa.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
