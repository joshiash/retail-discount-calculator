package com.ashwin.retail.discount;

public class DiscountSlab {
    private double min;
    private double max;
    private double discount;

    public DiscountSlab(double min, double max, double discount) {
        this.min = min;
        this.max = max;
        this.discount = discount;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getDiscount() {
        return discount;
    }

    public double getSlabAmount(){
        return this.max - this.min;
    }

    public boolean amountInSlab(double x)
    {
        return (this.getMin() < x && x <= this.getMax());
    }
}
