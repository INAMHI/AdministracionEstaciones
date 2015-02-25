package gob.inamhi.bean;

import gob.inamhi.domain.Umet;
import gob.inamhi.session.UmetFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "umetController")
@ViewScoped
public class UmetController extends AbstractController<Umet> implements Serializable {

    @EJB
    private UmetFacade ejbFacade;

    public UmetController() {
        super(Umet.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
