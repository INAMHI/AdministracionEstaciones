package gob.inamhi.bean;

import gob.inamhi.domain.Parm;
import gob.inamhi.session.ParmFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "parmController")
@ViewScoped
public class ParmController extends AbstractController<Parm> implements Serializable {

    @EJB
    private ParmFacade ejbFacade;
    private List<Parm> parametrosSource;
    private List<Parm> parametrosTarget = new ArrayList<Parm>();
    private DualListModel<Parm> parametros;

    public ParmController() {
        super(Parm.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public List<Parm> getParametrosSource() {
        if (parametrosSource == null) {
            parametrosSource = this.ejbFacade.buscarTodosParametros();
        }
        return parametrosSource;
    }

    public DualListModel<Parm> getParametros() {
//        getSensoresSource();
//        sensoresSource = null;
        setParametrosSource();
//        setSensoresTarget(new ArrayList<Sens>());
        return parametros = new DualListModel<Parm>(parametrosSource, parametrosTarget);
    }

    public DualListModel<Parm> getParametrosDual() {
//        getSensoresSource();
//        sensoresSource = null;
        return parametros;
    }

    public void setParametrosSource() {
//        if (sensoresSource == null) {
        parametrosSource = this.ejbFacade.buscarTodosParametros();
//        }
    }

    public void setParametrosTarget(int tipo) {
//        if (sensoresSource == null) {
        parametrosTarget = this.ejbFacade.encontrarAsignados(tipo);
//        setSensoresSource();
//        sensores = new DualListModel<Sens>(sensoresSource, sensoresTarget);
//        }
    }

    public void setParametros(DualListModel<Parm> parametros) {
        this.parametros = parametros;
    }

    public void setParametrosSource(List<Parm> parametrosSource) {
        this.parametrosSource = parametrosSource;
    }

    public void setParametrosTarget(List<Parm> parametrosTarget) {
        this.parametrosTarget = parametrosTarget;
    }

    public List<Parm> buscarParametrosPorTipo(int tipo) {
        return this.ejbFacade.encontrarAsignados(tipo);
    }

    public List<Integer> buscarParametrosPorEstacionAutomatica(int esta) {
        return this.ejbFacade.buscarTodosParametrosPorTipoEstacion(esta);
    }
    
    public List<Parm> buscarParametrosPorEstacionAutomaticaParm(int esta) {
        return this.ejbFacade.buscarTodosParametrosPorTipoEstacionParm(esta);
    }
}
