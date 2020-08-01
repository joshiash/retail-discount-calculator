package com.ashwin.retail.discount.costumer;

import com.ashwin.retail.discount.DiscountSlab;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RegularCustomerDiscount implements ICustomerDiscount {

    private List<DiscountSlab> discountSlabs;

    public RegularCustomerDiscount() {
        this.discountSlabs = new ArrayList<DiscountSlab>();
        discountSlabs.add(new DiscountSlab(0,5000,0));
        discountSlabs.add(new DiscountSlab(5000,10000,10));
        discountSlabs.add(new DiscountSlab(10000, Double.POSITIVE_INFINITY,20));
    }

    @Override
    public List<DiscountSlab> getDiscountSlabs() {
        return discountSlabs;
    }
}
