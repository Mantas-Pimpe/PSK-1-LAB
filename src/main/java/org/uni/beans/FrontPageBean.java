package org.uni.beans;

import lombok.Getter;
import lombok.Setter;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.uni.entities.Dealership;
import org.uni.persistance.DealershipPersistance;

@Named
@RequestScoped
public class FrontPageBean implements Serializable {

    @Getter
    @Setter
    private Dealership dealershipTmp = new Dealership();

    @Inject
    private DealershipPersistance dealershipPersistance;

    @Inject
    private DealershipPageBean dealershipPageBean;

    @Getter
    private List<Dealership> dealershipList;

    @PostConstruct
    public void init(){
        loadAllDealerships();
    }

    private void loadAllDealerships(){
        this.dealershipList = dealershipPersistance.loadAll().stream()
                .sorted(Comparator.comparingInt(Dealership::getId))
                        .collect(Collectors.toList());
    }

    @Transactional
    public String navigateToDealership(Dealership dealership){
        dealershipPageBean.loadData(dealershipPersistance.findOne(dealership.getId()));
        return "pages/dealershipEditForm.xhtml";
    }

    @Transactional
    public String createDealership(){
        this.dealershipPersistance.persist(dealershipTmp);
        dealershipList.add(dealershipTmp);
        dealershipTmp = new Dealership();
        return "index?faces-redirect=true";
    }

}
