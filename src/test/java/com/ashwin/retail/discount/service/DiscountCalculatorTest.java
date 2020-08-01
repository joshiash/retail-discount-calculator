package com.ashwin.retail.discount.service;

import com.ashwin.retail.discount.DiscountCalculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountCalculatorTest {

    @Autowired
    private DiscountCalculator discountCalculator;

    @Test
    public void testZeroDiscount(){
        double discount = discountCalculator.calculateDiscount(5000, "regular");
        assertEquals(discount,0,0);
    }

    @Test
    public void testFullDiscountForSlab(){
        double discount = discountCalculator.calculateDiscount(10000, "regular");
        assertEquals(discount,500,0);
    }

    @Test
    public void testDiscountWhenAmountInSlab(){
        double discount = discountCalculator.calculateDiscount(8000, "regular");
        assertEquals(discount,300,0);
    }
}
