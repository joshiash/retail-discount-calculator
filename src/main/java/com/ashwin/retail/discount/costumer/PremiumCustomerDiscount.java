package com.ashwin.retail.discount.costumer;

import com.ashwin.retail.discount.DiscountSlab;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PremiumCustomerDiscount implements ICustomerDiscount {

    private List<DiscountSlab> discountSlabs;

    public PremiumCustomerDiscount() {
        this.discountSlabs = new ArrayList<DiscountSlab>();
        discountSlabs.add(new DiscountSlab(0,4000,10));
        discountSlabs.add(new DiscountSlab(4000,8000,15));
        discountSlabs.add(new DiscountSlab(8000,12000,20));
        discountSlabs.add(new DiscountSlab(12000, Double.POSITIVE_INFINITY,30));
    }

    @Override
    public List<DiscountSlab> getDiscountSlabs() {
        return discountSlabs;
    }
}
