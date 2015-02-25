package gob.inamhi.bean;

import gob.inamhi.domain.Sens;
import gob.inamhi.session.SensFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

@ManagedBean(name = "sensController")
@ViewScoped
public class SensController extends AbstractController<Sens> implements Serializable {

    @EJB
    private SensFacade ejbFacade;
    private List<Sens> sensoresSource;
    private List<Sens> sensoresTarget = new ArrayList<Sens>();
    private DualListModel<Sens> sensores;

    public SensController() {
        super(Sens.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);


    }

    public List<Sens> getSensoresSource() {
        if (sensoresSource == null) {
            sensoresSource = this.ejbFacade.encontrarDisponibles();
        }
        return sensoresSource;
    }

    public DualListModel<Sens> getSensores() {
//        getSensoresSource();
//        sensoresSource = null;
        setSensoresSource();
//        setSensoresTarget(new ArrayList<Sens>());
        return sensores = new DualListModel<Sens>(sensoresSource, sensoresTarget);
    }

    public DualListModel<Sens> getSensoresDual() {
//        getSensoresSource();
//        sensoresSource = null;
        return sensores;
    }

    public void setSensoresSource() {
//        if (sensoresSource == null) {
        sensoresSource = this.ejbFacade.encontrarDisponibles();
//        }
    }

    public void setSensoresTarget(int esta) {
//        if (sensoresSource == null) {
        sensoresTarget = this.ejbFacade.encontrarInstalados(esta);
//        setSensoresSource();
//        sensores = new DualListModel<Sens>(sensoresSource, sensoresTarget);
//        }
    }

    public void setSensores(DualListModel<Sens> sensores) {
        this.sensores = sensores;
    }

    public void setSensoresSource(List<Sens> sensoresSource) {
        this.sensoresSource = sensoresSource;
    }

    public void setSensoresTarget(List<Sens> sensoresTarget) {
        this.sensoresTarget = sensoresTarget;
    }
}
