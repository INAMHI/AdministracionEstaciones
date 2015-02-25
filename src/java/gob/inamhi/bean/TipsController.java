package gob.inamhi.bean;

import gob.inamhi.domain.Tips;
import gob.inamhi.session.TipsFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tipsController")
@ViewScoped
public class TipsController extends AbstractController<Tips> implements Serializable {

    @EJB
    private TipsFacade ejbFacade;

    public TipsController() {
        super(Tips.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
