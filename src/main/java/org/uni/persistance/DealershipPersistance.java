package org.uni.persistance;

import org.uni.entities.Dealership;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class DealershipPersistance {

    @Inject
    private EntityManager em;

    public List<Dealership> loadAll() {
        return em.createNamedQuery("Dealership.findAll", Dealership.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Dealership team){
        this.em.persist(team);
    }

    public Dealership findOne(Integer id) {
        return em.find(Dealership.class, id);
    }
}
