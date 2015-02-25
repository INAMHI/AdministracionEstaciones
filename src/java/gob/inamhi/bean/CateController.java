package gob.inamhi.bean;

import gob.inamhi.domain.Cate;
import gob.inamhi.session.CateFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.inject.Inject;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cateController")
@ViewScoped
public class CateController extends AbstractController<Cate> implements Serializable {

    @EJB
    private CateFacade ejbFacade;

    public CateController() {
        super(Cate.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
