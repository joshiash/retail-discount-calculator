package com.ashwin.retail.discount.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountServiceTest {

    @Autowired
    private DiscountService discountService;

    @Test
    public void testRegularCustomerFor5000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(5000, "regular");
        assertEquals(discountedBill, 5000, 0);
    }

    @Test
    public void testRegularCustomerFor10000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(10000, "regular");
        assertEquals(discountedBill, 9500, 0);
    }

    @Test
    public void testRegularCustomerFor15000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(15000, "regular");
        assertEquals(discountedBill, 13500, 0);
    }

    @Test
    public void testPremiumCustomerFor4000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(4000, "premium");
        assertEquals(discountedBill, 3600, 0);
    }

    @Test
    public void testPremiumCustomerFor8000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(8000, "premium");
        assertEquals(discountedBill, 7000, 0);
    }

    @Test
    public void testPremiumCustomerFor12000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(12000, "premium");
        assertEquals(discountedBill, 10200, 0);
    }

    @Test
    public void testPremiumCustomerFor20000Bill()
    {
        double discountedBill = discountService.calculateDiscountedBill(20000, "premium");
        assertEquals(discountedBill, 15800, 0);
    }
}
