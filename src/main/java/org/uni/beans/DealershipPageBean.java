package org.uni.beans;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Dealership;
import org.uni.interceptors.LoggedInvocation;
import org.uni.persistance.DealershipPersistance;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@LoggedInvocation
@Named
@SessionScoped
public class DealershipPageBean implements Serializable, UpdateDealershipInterface {

    @Getter
    @Setter
    private Dealership dealership = new Dealership();

    @Getter
    @Setter
    private Dealership dealershipTmp = new Dealership();

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
        //System.out.println(id);
        //System.out.println(dealershipPersistance.findOne(id));
        setDealership(dealershipPersistance.findOne(id));

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String updateDealershipLocation() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        try {
            dealership.setName(dealershipTmp.getName());
            dealership.setLocation(dealershipTmp.getLocation());
            dealershipPersistance.update(this.dealership);
        } catch (OptimisticLockException e) {
            return "dealershipEditForm.xhtml?faces-redirect=true" + "&error=optimistic-lock-exception";
        }
        return "dealershipEditForm.xhtml?faces-redirect=true";
    }


    private CompletableFuture<String> contactOtherDealershipsTask = null;

    @LoggedInvocation
    public String contactOtherDealerships() {
        contactOtherDealershipsTask = CompletableFuture.supplyAsync(() -> mockContactMethod());

        return "dealershipEditForm.xhtml?faces-redirect=true";
    }

    public boolean isContactButtonEnabled() {
        return contactOtherDealershipsTask != null && !contactOtherDealershipsTask.isDone();
    }

    public String mockContactMethod() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        return "Hey!";
    }

    public String getContactStatusMessage() throws ExecutionException, InterruptedException {
        if (contactOtherDealershipsTask == null) {
            return null;
        } else if (!isContactButtonEnabled()) {
            return "Contacting...";
        }
        return "Contact message: " + contactOtherDealershipsTask.get();
    }
}
