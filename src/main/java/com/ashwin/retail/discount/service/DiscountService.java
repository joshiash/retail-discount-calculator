package com.ashwin.retail.discount.service;

import com.ashwin.retail.discount.DiscountSlab;
import com.ashwin.retail.discount.costumer.CustomerDiscountFactory;
import com.ashwin.retail.discount.costumer.ICustomerDiscount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountService {
    @Autowired
    private CustomerDiscountFactory customerDiscountFactory;

    public double calculateDiscountedBill(double bill, String customerType){
        return bill - calculateDiscount(bill,customerType);
    }

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
