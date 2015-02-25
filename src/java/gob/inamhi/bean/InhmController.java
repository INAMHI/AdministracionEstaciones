package gob.inamhi.bean;

import gob.inamhi.bean.util.JsfUtil;
import gob.inamhi.domain.Inhm;
import gob.inamhi.session.InhmFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "inhmController")
@ViewScoped
public class InhmController extends AbstractController<Inhm> implements Serializable {
    
    @EJB
    private InhmFacade ejbFacade;
    private Inhm inputInhm = new Inhm();
    
    public InhmController() {
        super(Inhm.class);
    }
    
    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
    
    public void setInputInhm(Inhm inputInhm) {
        this.inputInhm = inputInhm;
    }
    
    public Inhm getInputInhm() {
        return inputInhm;
    }
    
    public void guardarInhm() {
        getInputInhm().setInhmuing("ADMIN");
        this.ejbFacade.create(getInputInhm());
        JsfUtil.addSuccessMessage("Instrumento Ingresado Exitosamente");
        setInputInhm(new Inhm());
        setItems(null);
    }
    
    public void editarInhm() {
//        getInputInhm().setInhmuing("ADMIN");
        this.ejbFacade.edit(getSelected());
        JsfUtil.addSuccessMessage("Edición Correcta");
        setSelected(new Inhm());
        setItems(null);
    }
}
