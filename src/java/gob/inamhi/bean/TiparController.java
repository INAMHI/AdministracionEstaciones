package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Parm;
import gob.inamhi.domain.Tipar;
import gob.inamhi.session.TiparFacade;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "tiparController")
@SessionScoped
public class TiparController extends AbstractController<Tipar> implements Serializable {
    
    @EJB
    private TiparFacade ejbFacade;
    @ManagedProperty(value = "#{parmController}")
    private ParmController controladorParametros;
    private List<Parm> parametrosSource;
    private List<Parm> parametros;
    private Tipar inputTipar = new Tipar();
    
    public TiparController() {
        super(Tipar.class);
    }
    
    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public void guardarTipar() {
        parametros = controladorParametros.getParametrosDual().getTarget();
        parametrosSource = controladorParametros.getParametrosDual().getSource();
        Iterator it = parametros.iterator();
        this.ejbFacade.eliminarTipars(getInputTipar().getTipoId().getTipoId());
        while (it.hasNext()) {
            Parm aux = (Parm) it.next();
            getInputTipar().setParmId(aux);
            this.ejbFacade.create(getInputTipar());
        }
        setItems(null);
        JsfUtil.addSuccessMessage("Configuración Ingresada Exitosamente");
    }
    
    public Tipar getInputTipar() {
        return inputTipar;
    }
    
    public void setInputTipar(Tipar inputTipar) {
        this.inputTipar = inputTipar;
    }
    
    public List<Parm> getParametros() {
        return parametros;
    }
    
    public void setParametros(List<Parm> parametros) {
        this.parametros = parametros;
    }
    
    public void setControladorParametros(ParmController controladorParametros) {
        this.controladorParametros = controladorParametros;
    }
    
    public ParmController getControladorParametros() {
        return controladorParametros;
    }
    
    public void selectListener() {
        controladorParametros.setParametrosTarget(getInputTipar().getTipoId().getTipoId());
    }
}
