package com.ashwin.retail.discount.service;

import com.ashwin.retail.discount.DiscountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    @Autowired
    private DiscountCalculator discountCalculator;

    public double calculateDiscountedBill(double bill, String customerType){
        return bill - discountCalculator.calculateDiscount(bill,customerType);
    }

}
