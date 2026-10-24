package org.example.Study.LLD.PriceCalculator;

import java.util.List;

public class Seller {

    private final String id;
    private final String name;
    private final List<Address> addressList;
    private final SellerType sellerType;


    public  Address getPrimaryAddress(Address deliveryAddress){
        return null;
    }

    private Seller(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.addressList = List.copyOf(builder.addressList);
        this.sellerType = builder.sellerType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public SellerType getSellerType() {
        return sellerType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String id;
        private String name;
        private List<Address> addressList;
        private SellerType sellerType;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder addressList(List<Address> addressList) {
            this.addressList = addressList;
            return this;
        }

        public Builder sellerType(SellerType sellerType) {
            this.sellerType = sellerType;
            return this;
        }

        public Seller build() {
            return new Seller(this);
        }
    }
}