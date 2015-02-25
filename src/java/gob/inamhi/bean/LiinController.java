package gob.inamhi.bean;

import gob.inamhi.domain.Liin;
import gob.inamhi.session.LiinFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "liinController")
@ViewScoped
public class LiinController extends AbstractController<Liin> implements Serializable {

    @EJB
    private LiinFacade ejbFacade;

    public LiinController() {
        super(Liin.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
