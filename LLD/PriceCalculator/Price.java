package org.example.Study.LLD.PriceCalculator;

public class Price {

    private double finalPrice;
    private double discountAmount;
    private double distanceCharge;
    private double membershipDiscount;
    private double deliverySpeedCharge;
    private double sellerCharge;

    public Price(double finalPrice,
                 double discountAmount,
                 double distanceCharge,
                 double membershipDiscount,
                 double deliverySpeedCharge,
                 double sellerCharge) {

        this.finalPrice = finalPrice;
        this.discountAmount = discountAmount;
        this.distanceCharge = distanceCharge;
        this.membershipDiscount = membershipDiscount;
        this.deliverySpeedCharge = deliverySpeedCharge;
        this.sellerCharge = sellerCharge;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(double discountAmount) {
        this.discountAmount = discountAmount;
    }

    public double getDistanceCharge() {
        return distanceCharge;
    }

    public void setDistanceCharge(double distanceCharge) {
        this.distanceCharge = distanceCharge;
    }

    public double getMembershipDiscount() {
        return membershipDiscount;
    }

    public void setMembershipDiscount(double membershipDiscount) {
        this.membershipDiscount = membershipDiscount;
    }

    public double getDeliverySpeedCharge() {
        return deliverySpeedCharge;
    }

    public void setDeliverySpeedCharge(double deliverySpeedCharge) {
        this.deliverySpeedCharge = deliverySpeedCharge;
    }

    public double getSellerCharge() {
        return sellerCharge;
    }

    public void setSellerCharge(double sellerCharge) {
        this.sellerCharge = sellerCharge;
    }
}