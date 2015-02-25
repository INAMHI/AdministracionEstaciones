package gob.inamhi.bean;

import gob.inamhi.domain.Dtlg;
import gob.inamhi.session.DtlgFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "dtlgController")
@ViewScoped
public class DtlgController extends AbstractController<Dtlg> implements Serializable {

    @EJB
    private DtlgFacade ejbFacade;

    public DtlgController() {
        super(Dtlg.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
