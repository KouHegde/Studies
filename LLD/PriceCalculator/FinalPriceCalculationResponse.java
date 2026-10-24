package org.example.Study.LLD.PriceCalculator;

import java.time.LocalDateTime;

public class FinalPriceCalculationResponse {

    private final String quoteId;
    private final Price price;
    private final Package pkg;
    private final Address fromAddress;
    private final Address toAddress;
    private final String customerId;
    private final DeliverySpeed deliverySpeed;
    private final LocalDateTime createdAt;
    private final LocalDateTime estimatedDeliveryTime;

    public FinalPriceCalculationResponse(String quoteId,
                                         Price price,
                                         Package pkg,
                                         Address fromAddress,
                                         Address toAddress,
                                         String customerId,
                                         DeliverySpeed deliverySpeed,
                                         LocalDateTime createdAt,
                                         LocalDateTime estimatedDeliveryTime) {

        this.quoteId = quoteId;
        this.price = price;
        this.pkg = pkg;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.customerId = customerId;
        this.deliverySpeed = deliverySpeed;
        this.createdAt = createdAt;
        this.estimatedDeliveryTime = estimatedDeliveryTime;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public Price getPrice() {
        return price;
    }

    public Package getPkg() {
        return pkg;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public String getCustomerId() {
        return customerId;
    }

    public DeliverySpeed getDeliverySpeed() {
        return deliverySpeed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getEstimatedDeliveryTime() {
        return estimatedDeliveryTime;
    }
}