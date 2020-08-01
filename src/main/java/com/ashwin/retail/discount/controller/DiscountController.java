package com.ashwin.retail.discount.controller;

import com.ashwin.retail.discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @GetMapping("/discount")
    @ResponseBody
    public Double getDiscountedBill(@RequestParam(name="bill") double bill, @RequestParam(name="customerType") String customerType){
        return discountService.calculateDiscountedBill(bill, customerType);
    }
}
