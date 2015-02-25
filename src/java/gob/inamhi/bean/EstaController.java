package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Escat;
import gob.inamhi.domain.Esta;
import gob.inamhi.domain.Parm;
import gob.inamhi.session.EscatFacade;
import gob.inamhi.session.EstaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "estaController")
@ViewScoped
public class EstaController extends AbstractController<Esta> implements Serializable {

    @EJB
    private EstaFacade ejbFacade;
    private List<Esta> estaciones;
    @ManagedProperty(value = "#{parmController}")
    private ParmController controladorParametros;
    private List<Parm> parametros;
    private List<Parm> parametrosNuevos;
    private Esta inputEsta = new Esta();

    public EstaController() {
        super(Esta.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<Esta> getEstaciones() {
        if (estaciones == null) {
            estaciones = this.ejbFacade.ListarEstaciones();
        }
        return estaciones;
    }

    public void selectListener1() {
        setParametros(getSelected().getCatiId().getTipoId().getTipoId());
    }

    public void selectListener2() {
        setParametrosNuevos(getInputEsta().getCatiId().getTipoId().getTipoId());
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

    public void guardarEsta() {
        getInputEsta().setEstauing("ADMIN");
        this.ejbFacade.create(getInputEsta());
        JsfUtil.addSuccessMessage("Configuración Ingresada Exitosamente");
        setInputEsta(new Esta());
        setItems(null);
        parametros = null;
    }

    public void cancelarEsta() {
        setInputEsta(new Esta());
        setItems(null);
        parametros = null;
        //setSelected(null);
        parametrosNuevos = null;
    }

    public void cancelarEditarEsta() {
        setInputEsta(new Esta());
        setItems(null);

    }

    public Esta getInputEsta() {
        return inputEsta;
    }

    public void setInputEsta(Esta inputEsta) {
        this.inputEsta = inputEsta;
    }

    public List<Parm> getParametrosNuevos() {
        return parametrosNuevos;
    }

    public void setParametrosNuevos(int tipo) {
        this.parametrosNuevos = controladorParametros.buscarParametrosPorTipo(tipo);
    }
}
