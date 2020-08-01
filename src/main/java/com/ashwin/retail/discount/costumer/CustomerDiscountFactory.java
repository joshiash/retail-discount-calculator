package com.ashwin.retail.discount.costumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomerDiscountFactory {

    @Autowired
    private RegularCustomerDiscount regularCustomerDisocount;
    @Autowired
    private PremiumCustomerDiscount premiumCustomerDiscount;

    public ICustomerDiscount getCustomerDiscount(String customerType){
        if(customerType.equalsIgnoreCase("premium")){
            return premiumCustomerDiscount;
        }else{
            return regularCustomerDisocount;
        }
    }
}
