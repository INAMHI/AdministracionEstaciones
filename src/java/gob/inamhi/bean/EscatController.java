package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Escat;
import gob.inamhi.domain.Parm;
import gob.inamhi.session.EscatFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "escatController")
@ViewScoped
public class EscatController extends AbstractController<Escat> implements Serializable {

    @EJB
    private EscatFacade ejbFacade;
    @ManagedProperty(value = "#{parmController}")
    private ParmController controladorParametros;
    private List<Parm> parametros;
    private List<Parm> parametrosNuevos;
    private Escat inputEscat = new Escat();

    public EscatController() {
        super(Escat.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public void selectListener1() {
        setParametros(getSelected().getCatiId().getTipoId().getTipoId());
    }

    public void selectListener2() {
        setParametrosNuevos(getInputEscat().getCatiId().getTipoId().getTipoId());
    }

    public void setControladorParametros(ParmController controladorParametros) {
        this.controladorParametros = controladorParametros;
    }

    public ParmController getControladorParametros() {
        return controladorParametros;
    }

    public void setParametros(int tipo) {
        this.parametros = controladorParametros.buscarParametrosPorTipo(tipo);
    }

    public List<Parm> getParametros() {
        return parametros;
    }

    public void guardarEscat() {
        getInputEscat().setEscatuing("ADMIN");
        this.ejbFacade.create(getInputEscat());
        JsfUtil.addSuccessMessage("Configuración Ingresada Exitosamente");
        setInputEscat(new Escat());
        setItems(null);
        parametros = null;
    }

    public void cancelarEscat() {
        setInputEscat(new Escat());
        setItems(null);
        parametros = null;
        //setSelected(null);
        parametrosNuevos = null;
    }

    public void cancelarEditarEscat() {
        setInputEscat(new Escat());
        setItems(null);

    }

    public Escat getInputEscat() {
        return inputEscat;
    }

    public void setInputEscat(Escat inputEscat) {
        this.inputEscat = inputEscat;
    }

    public List<Parm> getParametrosNuevos() {
        return parametrosNuevos;
    }

    public void setParametrosNuevos(int tipo) {
        this.parametrosNuevos = controladorParametros.buscarParametrosPorTipo(tipo);
    }
}
