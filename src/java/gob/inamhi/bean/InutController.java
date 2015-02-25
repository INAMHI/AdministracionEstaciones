package gob.inamhi.bean;

import gob.inamhi.domain.Inut;
import gob.inamhi.session.InutFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "inutController")
@ViewScoped
public class InutController extends AbstractController<Inut> implements Serializable {

    @EJB
    private InutFacade ejbFacade;

    public InutController() {
        super(Inut.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
