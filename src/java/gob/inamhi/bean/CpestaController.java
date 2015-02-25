package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Copa;
import gob.inamhi.domain.Cpesta;
import gob.inamhi.session.CpestaFacade;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cpestaController")
@ViewScoped
public class CpestaController extends AbstractController<Cpesta> implements Serializable {

    @EJB
    private CpestaFacade ejbFacade;
    @ManagedProperty(value = "#{copaController}")
    private CopaController controladorCopas;
    private List<Copa> copasSource;
    private List<Copa> copas;
    private Cpesta inputCpesta = new Cpesta();

    public CpestaController() {
        super(Cpesta.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }

    public void guardarCpesta() {
        copas = controladorCopas.getCopasDual().getTarget();
//        copasSource = controladorCopas.getCopasDual().getSource();
        Iterator it = copas.iterator();
        int esta = getInputCpesta().getEstaId().getEstaId();
        this.ejbFacade.eliminarCpestas(esta);
        while (it.hasNext()) {
            Copa aux = (Copa) it.next();
            getInputCpesta().setCopaId(aux);
            getInputCpesta().setCpestauing("ADMIN");
            this.ejbFacade.create(getInputCpesta());
        }
        setItems(null);
        JsfUtil.addSuccessMessage("Configuración Ingresada Exitosamente");
    }

    public CopaController getControladorCopas() {
        return controladorCopas;
    }

    public void setControladorCopas(CopaController controladorCopas) {
        this.controladorCopas = controladorCopas;
    }

    public List<Copa> getCopasSource() {
        return copasSource;
    }

    public void setCopasSource(List<Copa> copasSource) {
        this.copasSource = copasSource;
    }

    public List<Copa> getCopas() {
        return copas;
    }

    public void setCopas(List<Copa> copas) {
        this.copas = copas;
    }

    public Cpesta getInputCpesta() {
        return inputCpesta;
    }

    public void setInputCpesta(Cpesta inputCpesta) {
        this.inputCpesta = inputCpesta;
    }

    public void selectListener() {
        controladorCopas.setCopasTarget(getInputCpesta().getEstaId().getEstaId());
        controladorCopas.setCopasSource(getInputCpesta().getEstaId().getEstaId());
    }
}
