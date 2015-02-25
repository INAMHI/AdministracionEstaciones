package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Cfges;
import gob.inamhi.domain.Ines;
import gob.inamhi.domain.Sens;
import gob.inamhi.session.CfgesFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cfgesController")
@ViewScoped
public class CfgesController extends AbstractController<Cfges> implements Serializable {

    @EJB
    private CfgesFacade ejbFacade;
    @ManagedProperty(value = "#{sensController}")
    private SensController controladorSensores;
    @ManagedProperty(value = "#{inhmController}")
    private InhmController controladorInstrumental;
    private List<Sens> sensores;
    private List<Sens> sensoresSource;
    private Cfges inputCfges = new Cfges();

    public CfgesController() {
        super(Cfges.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public void guardarCfges() {
        sensores = controladorSensores.getSensoresDual().getTarget();
        sensoresSource = controladorSensores.getSensoresDual().getSource();
        Iterator it = sensores.iterator();
        int contador = 1;
        while (it.hasNext()) {
            Sens aux = (Sens) it.next();
            Ines ines = new Ines(1);
            aux.getInhmId().setInesId(ines);
            controladorInstrumental.setSelected(aux.getInhmId());
            if (aux.getInhmId().getInhmId() != 1) {
                controladorInstrumental.getFacade().edit(controladorInstrumental.getSelected());
            }

            getInputCfges().setSensId(aux);
            getInputCfges().setCfgesords(contador++);
            getInputCfges().setCfgesuing("ADMIN");
            this.ejbFacade.create(getInputCfges());
        }

        Iterator it2 = sensoresSource.iterator();

        while (it2.hasNext()) {
            Sens aux = (Sens) it2.next();
            Ines ines = new Ines(7);
            int inesActual = aux.getInhmId().getInesId().getInesId();
            if (inesActual == 1) {
                aux.getInhmId().setInesId(ines);
                controladorInstrumental.setSelected(aux.getInhmId());
                controladorInstrumental.getFacade().edit(controladorInstrumental.getSelected());
            }
        }

        setInputCfges(new Cfges());
        setItems(null);
        controladorSensores.setSensoresSource(null);
        controladorSensores.setSensoresTarget(new ArrayList<Sens>());

        JsfUtil.addSuccessMessage("Configuración Ingresada Exitosamente");
    }

    public void cancelarCfges() {

        setInputCfges(new Cfges());
        setItems(null);
    }

    public void selectListener() {
        controladorSensores.setSensoresTarget(getInputCfges().getEstaId().getEstaId());
    }

    public SensController getControladorSensores() {
        return controladorSensores;
    }

    public void setControladorSensores(SensController controladorSensores) {
        this.controladorSensores = controladorSensores;
    }

    public InhmController getControladorInstrumental() {
        return controladorInstrumental;
    }

    public void setControladorInstrumental(InhmController controladorInstrumental) {
        this.controladorInstrumental = controladorInstrumental;
    }

    public Cfges getInputCfges() {
        return inputCfges;
    }

    public void setInputCfges(Cfges inputCfges) {
        this.inputCfges = inputCfges;
    }
}
