package gob.inamhi.bean;

import gob.inamhi.domain.Copa;
import gob.inamhi.session.CopaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "copaController")
@ViewScoped
public class CopaController extends AbstractController<Copa> implements Serializable {

    @EJB
    private CopaFacade ejbFacade;
    private List<Copa> copasSource;
    private List<Copa> copasTarget = new ArrayList<Copa>();
    private DualListModel<Copa> copas;
    @ManagedProperty(value = "#{parmController}")
    private ParmController controladorParametros;

    public CopaController() {
        super(Copa.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<Copa> getCopasSource() {
        if (copasSource == null) {
            copasSource = this.ejbFacade.buscarTodosCopas();
        }
        return copasSource;
    }

    public void setCopasSource(int esta) {
        List<Integer> aux = controladorParametros.buscarParametrosPorEstacionAutomatica(esta);
        if (aux.isEmpty()) {
            copasSource = this.ejbFacade.buscarTodosCopas();
        } else {
            copasSource = this.ejbFacade.buscarTodosCopasPorParm(aux);
        }
    }

    public List<Copa> getCopasTarget() {
        return copasTarget;
    }

    public void setCopasTarget(int esta) {
        copasTarget = this.ejbFacade.encontrarAsignados(esta);
    }

    public DualListModel<Copa> getCopas() {
        getCopasSource();
//        setSensoresTarget(new ArrayList<Sens>());
        return copas = new DualListModel<Copa>(copasSource, copasTarget);
    }

    public DualListModel<Copa> getCopasDual() {
        return copas;
    }

    public void setCopas(DualListModel<Copa> parametros) {
        this.copas = parametros;
    }

    public List<Copa> buscarCopasPorEstacion(int esta) {
        return this.ejbFacade.encontrarAsignados(esta);
    }

    public ParmController getControladorParametros() {
        return controladorParametros;
    }

    public void setControladorParametros(ParmController controladorParametros) {
        this.controladorParametros = controladorParametros;
    }
}
