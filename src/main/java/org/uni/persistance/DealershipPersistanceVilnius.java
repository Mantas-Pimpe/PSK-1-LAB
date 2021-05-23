package org.uni.persistance;

import org.uni.entities.Dealership;

import javax.enterprise.inject.Specializes;

@Specializes
public class DealershipPersistanceVilnius extends DealershipPersistance{
    @Override
    public Dealership update(Dealership gun) {
        gun.setLocation(gun.getLocation() + ", Vilnius");
        return super.update(gun);
    }
}
