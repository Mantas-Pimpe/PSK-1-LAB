package org.uni.beans;

import javax.enterprise.inject.Alternative;

@Alternative
public class Salesman implements SalesmanInterface{
    @Override
    public void sellCar() {
        System.out.println("SELL CAR REAL");
    }
}
