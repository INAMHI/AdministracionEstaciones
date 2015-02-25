package gob.inamhi.bean;

import gob.inamhi.domain.Tipo;
import gob.inamhi.session.TipoFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tipoController")
@ViewScoped
public class TipoController extends AbstractController<Tipo> implements Serializable {

    @EJB
    private TipoFacade ejbFacade;

    public TipoController() {
        super(Tipo.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
