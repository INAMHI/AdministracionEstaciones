package gob.inamhi.bean;

import gob.inamhi.domain.Umep;
import gob.inamhi.session.UmepFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "umepController")
@ViewScoped
public class UmepController extends AbstractController<Umep> implements Serializable {

    @EJB
    private UmepFacade ejbFacade;

    public UmepController() {
        super(Umep.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
