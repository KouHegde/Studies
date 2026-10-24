package org.example.Study.LLD.PriceCalculator;

public class Package {

    private final String id;
    private final Double basePrice;
    private final String name;
    private final String sellerId;
    private final String description;
    private final double width;
    private final double height;
    private final double length;
    private final Double weight;

    private Package(Builder builder) {
        this.id = builder.id;
        this.basePrice = builder.basePrice;
        this.name = builder.name;
        this.sellerId = builder.sellerId;
        this.description = builder.description;
        this.width = builder.width;
        this.height = builder.height;
        this.length = builder.length;
        this.weight = builder.weight;
    }

    public String getId() {
        return id;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public String getName() {
        return name;
    }

    public String getSellerId() {
        return sellerId;
    }

    public String getDescription() {
        return description;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public Double getWeight() {
        return weight;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private Double basePrice;
        private String name;
        private String sellerId;
        private String description;
        private double width;
        private double height;
        private double length;
        private Double weight;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder basePrice(Double basePrice) {
            this.basePrice = basePrice;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder sellerId(String sellerId) {
            this.sellerId = sellerId;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder width(double width) {
            this.width = width;
            return this;
        }

        public Builder height(double height) {
            this.height = height;
            return this;
        }

        public Builder length(double length) {
            this.length = length;
            return this;
        }

        public Builder weight(Double weight) {
            this.weight = weight;
            return this;
        }

        public Package build() {
            return new Package(this);
        }
    }
}