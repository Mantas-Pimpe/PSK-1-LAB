package org.uni.beans;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Dealership;
import org.uni.persistance.DealershipPersistance;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@Named
@SessionScoped
public class DealershipPageBean implements Serializable {

    @Getter
    @Setter
    private Dealership dealership = new Dealership();

    @Inject
    private DealershipPersistance dealershipPersistance;

    @PostConstruct
    public void init(){

    }

    @Transactional
    public void loadData(Dealership dealership){
        setDealership(dealership);
    }

    @Transactional
    public void reload(Integer id) throws IOException {
        System.out.println(id);
        System.out.println(dealershipPersistance.findOne(id));
        setDealership(dealershipPersistance.findOne(id));

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }
}
