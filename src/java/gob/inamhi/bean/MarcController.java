package gob.inamhi.bean;

import gob.inamhi.domain.Marc;
import gob.inamhi.session.MarcFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "marcController")
@ViewScoped
public class MarcController extends AbstractController<Marc> implements Serializable {

    @EJB
    private MarcFacade ejbFacade;

    public MarcController() {
        super(Marc.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
