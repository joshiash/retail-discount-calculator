package com.ashwin.retail.discount;

import com.ashwin.retail.discount.costumer.CustomerDiscountFactory;
import com.ashwin.retail.discount.costumer.ICustomerDiscount;
import com.ashwin.retail.discount.costumer.RegularCustomerDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DiscountCalculator {

    @Autowired
    private CustomerDiscountFactory customerDiscountFactory;

    public double calculateDiscount(double bill, String customerType) {
        double discount = 0;
        ICustomerDiscount customerDiscount= customerDiscountFactory.getCustomerDiscount(customerType);
        List<DiscountSlab> discountSlabs = customerDiscount.getDiscountSlabs();
        for(DiscountSlab discountslab : discountSlabs){
            if(discountslab.getDiscount() !=0 ) {
                if (bill > discountslab.getMax()) {
                    double discountForSlab = discountslab.getSlabAmount() * discountslab.getDiscount() / 100;
                    discount = discount + discountForSlab;
                } else if (discountslab.amountInSlab(bill)) {
                    double discountForSlab = (bill - discountslab.getMin()) * discountslab.getDiscount() / 100;
                    discount = discount + discountForSlab;
                }
            }
        }
        return discount;
    }
}
