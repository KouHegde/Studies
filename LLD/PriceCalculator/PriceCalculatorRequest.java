package org.example.Study.LLD.PriceCalculator;


public class PriceCalculatorRequest {

    private Package pkg;
    private Address fromAddress;
    private Address toAddress;
    private String deliveryId;
    private String customerId;
    private DeliverySpeed deliverySpeed;

    public PriceCalculatorRequest(Package pkg,
                                  Address fromAddress,
                                  Address toAddress,
                                  String deliveryId,
                                  String customerId,
                                  DeliverySpeed deliverySpeed) {

        this.pkg = pkg;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.deliveryId = deliveryId;
        this.customerId = customerId;
        this.deliverySpeed = deliverySpeed;
    }

    public Package getPkg() {
        return pkg;
    }

    public void setPkg(Package pkg) {
        this.pkg = pkg;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(Address fromAddress) {
        this.fromAddress = fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public void setToAddress(Address toAddress) {
        this.toAddress = toAddress;
    }

    public String getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(String deliveryId) {
        this.deliveryId = deliveryId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public DeliverySpeed getDeliverySpeed() {
        return deliverySpeed;
    }

    public void setDeliverySpeed(DeliverySpeed deliverySpeed) {
        this.deliverySpeed = deliverySpeed;
    }
}

