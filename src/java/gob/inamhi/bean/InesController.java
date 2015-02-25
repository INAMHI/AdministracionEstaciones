package gob.inamhi.bean;

import gob.inamhi.domain.Ines;
import gob.inamhi.session.InesFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "inesController")
@ViewScoped
public class InesController extends AbstractController<Ines> implements Serializable {

    @EJB
    private InesFacade ejbFacade;

    public InesController() {
        super(Ines.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
