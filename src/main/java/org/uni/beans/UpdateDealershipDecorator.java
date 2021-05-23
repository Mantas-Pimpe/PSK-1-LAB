package org.uni.beans;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class UpdateDealershipDecorator implements UpdateDealershipInterface {
    @Inject
    @Delegate
    @Any
    UpdateDealershipInterface updateDealershipInterface;

    @Override
    public String updateDealershipLocation() throws InterruptedException {
        String result = updateDealershipInterface.updateDealershipLocation();
        return result + "&decorated=yes";
    }
}
